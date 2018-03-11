package org.hintze.strategy;

/**
 * holds method for lambda rules
 */
public interface PricingRuleCalculation {

    Integer applyDiscount(Integer unitPrice);
}
