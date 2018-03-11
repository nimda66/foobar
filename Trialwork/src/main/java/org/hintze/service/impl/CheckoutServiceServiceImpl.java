package org.hintze.service.impl;

import org.hintze.model.SKU;
import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.service.PriceRuleService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CheckoutServiceServiceImpl implements CheckoutService {

    private static final Logger LOGGER = Logger.getLogger("CheckoutServiceServiceImpl");
    private Object pricingRules = new Object();//TODO hin default
    private final List<SKU> skuList = new ArrayList<>();
    private final PriceRuleService priceRuleService = new PriceRuleServiceImpl(pricingRules);

    @Override
    @Deprecated
    public CheckoutService newInstance(final Object pricingRules) {
        this.pricingRules = pricingRules;
        return new CheckoutServiceServiceImpl();//TODO hin
    }

    @Override
    public void scan(String unitName) {
        UnitType unitType = UnitType.forName(unitName);
        SKU sku = new SKU(unitName, unitType);
        addSKU(sku);
        LOGGER.info("Unit: " + unitName + ", price: " + unitType.getPrice());
    }

    @Override
    public BigDecimal total() {
//        skuList.stream().mapToInt(SKU::getPrice).sum();
        AtomicInteger sumTotal = new AtomicInteger();

        Arrays.stream(UnitType.values()).forEach(unitType -> {

            long itemCountByType = skuList.stream().filter(sku -> unitType.equals(sku.getUnitType())).count();
            LOGGER.info("unitType: " + unitType.name() + " |count: " + itemCountByType);
            //TODO hin add special
            sumTotal.addAndGet(priceRuleService.calculateByType(unitType, itemCountByType));
        });

        return BigDecimal.valueOf(sumTotal.get());
    }

    private void addSKU(SKU sku) {
        skuList.add(sku);
    }

}
