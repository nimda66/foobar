package org.hintze.strategy;

import org.hintze.model.UnitType;

import java.util.Map;
import java.util.TreeMap;

/**
 * holds special pricing rules for each {@link UnitType}
 */
public interface PricingStrategy {

    Map<UnitType, PricingRuleCalculation> rules = new TreeMap<>();

    default Map<UnitType, PricingRuleCalculation> rules() {
        return rules;
    }
}
