package org.hintze.service.impl;

import org.hintze.model.UnitType;
import org.hintze.service.PriceRuleService;

import static org.hintze.service.PriceRuleService.PricingRule.discountForA;

public class PriceRuleServiceImpl implements PriceRuleService {

    private PricingRule pricingRules;

    public PriceRuleServiceImpl(PricingRule pricingRules) {
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
