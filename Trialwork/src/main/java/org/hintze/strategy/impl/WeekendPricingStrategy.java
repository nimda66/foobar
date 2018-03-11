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
        rules.put(UnitType.ZERO, (sumByType) -> 0);
        rules.put(UnitType.A,
                (sumByType) -> sumByType - 14);
        rules.put(UnitType.B,
                (sumByType) -> sumByType - 13);
        rules.put(UnitType.C, (sumByType) -> sumByType - 12);
        rules.put(UnitType.D, (sumByType) -> sumByType - 11);

        return rules;
    }


}
