package org.hintze.service.impl;

import org.hintze.model.SKU;
import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.service.PriceCalculationService;
import org.hintze.strategy.PricingStrategy;
import org.hintze.strategy.impl.DefaultPricingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CheckoutServiceImpl implements CheckoutService {

    private static final Logger LOGGER = Logger.getLogger("CheckoutServiceImpl");
    private final List<SKU> skuList = new ArrayList<>();
    private PriceCalculationService priceCalculationService;

    /**
     * uses default pricing
     */
    public CheckoutServiceImpl() {
        this(new DefaultPricingStrategy());
    }

    public CheckoutServiceImpl(PricingStrategy pricingStrategy) {
        priceCalculationService = new PriceCalculationServiceImpl(pricingStrategy);
    }

    @Override
    public void scan(String unitName) {
        UnitType unitType = UnitType.forName(unitName);
        SKU sku = new SKU(unitName, unitType);
        addSKU(sku);
        LOGGER.fine("Unit: " + unitName + ", price: " + unitType.getPrice());
    }

    @Override
    public int total() {
        AtomicInteger sumTotal = new AtomicInteger();

        Arrays.stream(UnitType.values()).forEach(unitType -> {

            long itemCountByType = skuList.stream().filter(sku -> unitType.equals(sku.getUnitType())).count();
            LOGGER.info("unitType: " + unitType.name() + " |count: " + itemCountByType);
            sumTotal.addAndGet(priceCalculationService.calculateByType(unitType, itemCountByType));
        });

        return sumTotal.get();
    }

    private void addSKU(SKU sku) {
        skuList.add(sku);
    }

}
