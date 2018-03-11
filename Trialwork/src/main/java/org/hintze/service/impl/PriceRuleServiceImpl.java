package org.hintze.service.impl;

import org.hintze.model.UnitType;
import org.hintze.service.PriceRuleService;

public class PriceRuleServiceImpl implements PriceRuleService {

    private Object pricingRules = new Object();//TODO hin default

    public PriceRuleServiceImpl(Object pricingRules) {
        this.pricingRules = pricingRules;
    }
@Override
    public int calculateByType(UnitType unitType, long count) {

        return 666;
    }
}
