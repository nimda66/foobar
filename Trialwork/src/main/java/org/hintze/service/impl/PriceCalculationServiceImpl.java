package org.hintze.service.impl;

import org.hintze.model.UnitType;
import org.hintze.service.PriceCalculationService;
import org.hintze.strategy.PricingRuleCalculation;
import org.hintze.strategy.PricingStrategy;


public class PriceCalculationServiceImpl implements PriceCalculationService {

    private PricingStrategy pricingStrategy;

    /**
     * @param pricingStrategy
     */
    public PriceCalculationServiceImpl(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public int calculateByType(UnitType unitType, long count) {

        int sumByType = (int) (unitType.getPrice() * count);
        PricingRuleCalculation pricingRuleForType = getPricingRuleForType(unitType);
        return pricingRuleForType.applyDiscount(sumByType);
    }

    private PricingRuleCalculation getPricingRuleForType(UnitType unitType) {
        return pricingStrategy.rules().get(unitType);
    }

}
