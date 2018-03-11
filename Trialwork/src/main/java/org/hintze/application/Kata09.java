package org.hintze.application;

import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.service.impl.CheckoutServiceImpl;
import org.hintze.strategy.PricingStrategy;
import org.hintze.strategy.impl.WeekendPricingStrategy;

import java.util.logging.Logger;

/**
 * sample application,uses 2 different rule sets
 *
 * demo , contains no database, spring or error handling
 */
public class Kata09 {

    private static final Logger LOGGER = Logger.getLogger("Kata09");

    public static void main(String[] args) {
        //default strategy
        CheckoutService checkoutService = new CheckoutServiceImpl();
        checkoutService.scan(UnitType.A.name());
        checkoutService.scan(UnitType.A.name());
        checkoutService.scan(UnitType.D.name());
        checkoutService.scan(UnitType.C.name());
        checkoutService.scan(UnitType.B.name());
        LOGGER.info("CheckoutService total: " + checkoutService.total()+" cent");

        //different strategy
        PricingStrategy weekendPricingStrategy = new WeekendPricingStrategy();
        CheckoutServiceImpl weekendCheckoutService = new CheckoutServiceImpl(weekendPricingStrategy);
        weekendCheckoutService.scan(UnitType.A.name());
        weekendCheckoutService.scan(UnitType.A.name());
        weekendCheckoutService.scan(UnitType.D.name());
        weekendCheckoutService.scan(UnitType.C.name());
        weekendCheckoutService.scan(UnitType.B.name());
        LOGGER.info("WeekendCheckoutService total: " + weekendCheckoutService.total()+" cent");
    }
}
