package org.hintze.service;

import org.hintze.model.UnitType;

public interface PriceCalculationService {

    int calculateByType(UnitType unitType, long count);
}
