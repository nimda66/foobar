package org.hintze.strategy.impl;

import org.hintze.model.UnitType;
import org.hintze.strategy.PricingRuleCalculation;
import org.hintze.strategy.PricingStrategy;

import java.util.Map;

/**
 * standard rules for special prices by {@link UnitType}
 */
public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public Map<UnitType, PricingRuleCalculation> rules() {
        rules.put(UnitType.ZERO, (sumByType) -> 0);
        rules.put(UnitType.A,
                (sumByType) -> {
                    int numberOfItems = (int) sumByType / UnitType.A.getPrice();
                    int numberOfDiscounts = (int) numberOfItems / 3;
                    return sumByType - numberOfDiscounts * 20;
                });
        rules.put(UnitType.B,
                (sumByType) -> {
                    int numberOfItems = (int) sumByType / UnitType.B.getPrice();
                    int numberOfDiscounts = (int) numberOfItems / 2;
                    return sumByType - numberOfDiscounts * 15 ;
                });
        rules.put(UnitType.C, (sumByType) -> sumByType);
        rules.put(UnitType.D, (sumByType) -> sumByType);

        return rules;
    }
}
