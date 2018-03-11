package org.hintze.service;

import org.hintze.model.UnitType;

public interface PriceRuleService {


    int calculateByType(UnitType unitType, long count);

    interface PricingRule {

        int applyDiscount(int unitPrice);

    //    default int applyDiscount(int unitPrice) {
    //        return discountForA().applyDiscount(unitPrice);
    //    }


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
}
