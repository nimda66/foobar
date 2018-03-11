package org.hintze.strategy.impl;

import org.hintze.model.UnitType;
import org.hintze.strategy.PricingRuleCalculation;
import org.hintze.strategy.PricingStrategy;

import java.util.Map;

/**
 * demos just different rules!
 */
public class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public Map<UnitType, PricingRuleCalculation> rules() {
        rules.put(UnitType.ZERO, (unitPrice) -> 0);
        rules.put(UnitType.A,
                (unitPrice) -> unitPrice - 14);
        rules.put(UnitType.B,
                (unitPrice) -> unitPrice - 13);
        rules.put(UnitType.C, (unitPrice) -> unitPrice - 12);
        rules.put(UnitType.D, (unitPrice) -> unitPrice - 11);

        return rules;
    }


}
