package org.hintze.service;

import org.hintze.model.UnitType;

public interface PriceRuleService {


    int calculateByType(UnitType unitType, long count);
}
