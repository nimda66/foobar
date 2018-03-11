package org.hintze.service;

import org.hintze.model.UnitType;

/**
 * calculates special prices by {@link UnitType} using {@link org.hintze.strategy.PricingStrategy}
 */
public interface PriceCalculationService {

    /**
     * @param unitType
     * @param count
     * @return total for type, (price rules applied)
     */
    int calculateByType(UnitType unitType, long count);
}
