package org.hintze.strategy.impl;

import org.hintze.model.UnitType;
import org.hintze.strategy.PricingRuleCalculation;
import org.hintze.strategy.PricingStrategy;

import java.util.Map;

/**
 * standard rules for special prices
 */
public  class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public Map<UnitType, PricingRuleCalculation> rules() {
        rules.put(UnitType.ZERO,(unitPrice) -> 0);
        rules.put(UnitType.A,
                (unitPrice) -> unitPrice >= 150 ? unitPrice - 20 : unitPrice);
        rules.put(UnitType.B,
                (unitPrice) -> unitPrice >= 60 ? unitPrice - 15 : unitPrice);
        rules.put(UnitType.C, (unitPrice) -> unitPrice);
        rules.put(UnitType.D, (unitPrice) -> unitPrice);

        return rules;
    }
}
