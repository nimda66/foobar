package org.hintze.strategy;

public interface PricingRule {
    int applyDiscount(int unitPrice);

    static PricingRule discountForA() {
        return unitPrice -> unitPrice >= 150 ? unitPrice - 20 : unitPrice;
    }

    static PricingRule discountForB() {
        return unitPrice -> unitPrice >= 60 ? unitPrice - 15 : unitPrice;
    }

    static PricingRule discountForC() {
        return unitPrice -> unitPrice;
    }

    static PricingRule discountForD() {
        return unitPrice -> unitPrice;
    }
}
