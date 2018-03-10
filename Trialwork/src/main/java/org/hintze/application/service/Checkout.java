package org.hintze.application.service;

import java.math.BigDecimal;

public interface Checkout {

    Checkout newInstance(Object pricingRules);

    BigDecimal scan(String item);

    BigDecimal total();

}
