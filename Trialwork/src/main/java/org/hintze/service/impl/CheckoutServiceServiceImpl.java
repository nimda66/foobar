package org.hintze.service.impl;

import org.hintze.model.SKU;
import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.service.PriceCalculationService;
import org.hintze.strategy.PricingRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CheckoutServiceServiceImpl implements CheckoutService {

    private static final Logger LOGGER = Logger.getLogger("CheckoutServiceServiceImpl");
    private PricingRule pricingRules;//TODO hin default
    private final List<SKU> skuList = new ArrayList<>();
    private final PriceCalculationService priceCalculationService = new PriceCalculationServiceImpl(pricingRules);

    @Override
    public void scan(String unitName) {
        UnitType unitType = UnitType.forName(unitName);
        SKU sku = new SKU(unitName, unitType);
        addSKU(sku);
        LOGGER.info("Unit: " + unitName + ", price: " + unitType.getPrice());
    }

    @Override
    public int total() {
        AtomicInteger sumTotal = new AtomicInteger();

        Arrays.stream(UnitType.values()).forEach(unitType -> {

            long itemCountByType = skuList.stream().filter(sku -> unitType.equals(sku.getUnitType())).count();
            LOGGER.info("unitType: " + unitType.name() + " |count: " + itemCountByType);
            //TODO hin add special
            sumTotal.addAndGet(priceCalculationService.calculateByType(unitType, itemCountByType));
        });

        return sumTotal.get();
    }

    private void addSKU(SKU sku) {
        skuList.add(sku);
    }

}
