package org.hintze.service;

import java.math.BigDecimal;

public interface Checkout {

    Checkout newInstance(Object pricingRules);

    void scan(String item);

    BigDecimal total();

}
