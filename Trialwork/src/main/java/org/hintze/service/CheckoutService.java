package org.hintze.service;

import java.math.BigDecimal;

public interface CheckoutService {

    CheckoutService newInstance(Object pricingRules);

    void scan(String item);

    BigDecimal total();

}
