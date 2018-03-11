package org.hintze.service;

public interface CheckoutService {

    CheckoutService newInstance(PriceRuleService.PricingRule pricingRules);

    void scan(String item);

    int total();

}
