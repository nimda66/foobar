package org.hintze.service.impl;

import org.hintze.model.UnitType;
import org.hintze.service.PriceRuleService;
import org.hintze.service.PricingRule;

public class PriceRuleServiceImpl implements PriceRuleService {

    private PricingRule pricingRules;

    public PriceRuleServiceImpl(PricingRule pricingRules) {
        this.pricingRules = pricingRules;
    }

    @Override
    public int calculateByType(UnitType unitType, long count) {

        int sumByType= (int) (unitType.getPrice()*count);
//
//        pricingRules.discountForC();
////                .applyDiscount(int);


        return 666;
    }

    public PricingRule getPricingRules() {
        return pricingRules;
    }

    public void setPricingRules(PricingRule pricingRules) {
        this.pricingRules = pricingRules;
    }
}
