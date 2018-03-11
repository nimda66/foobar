package org.hintze.service;

public interface CheckoutService {

    CheckoutService newInstance(PricingRule pricingRules);

    void scan(String item);

    int total();

}
