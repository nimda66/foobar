package org.hintze.service.impl;

import org.hintze.model.UnitType;
import org.hintze.service.PriceCalculationService;
import org.hintze.strategy.PricingRule;

import static org.hintze.strategy.PricingRule.discountForA;


public class PriceCalculationServiceImpl implements PriceCalculationService {

    private PricingRule pricingRules;

    public PriceCalculationServiceImpl(PricingRule pricingRules) {
        this.pricingRules= pricingRules;
    }

    @Override
    public int calculateByType(UnitType unitType, long count) {

        int sumByType = (int) (unitType.getPrice() * count);
        int result = discountForA().applyDiscount(sumByType);
        return result;
    }

    public PricingRule getPricingRules() {
        return pricingRules;
    }

    public void setPricingRules(PricingRule pricingRules) {
        this.pricingRules = pricingRules;
    }
}
