package org.hintze.application;

import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.service.impl.CheckoutServiceServiceImpl;

import java.util.logging.Logger;

/**
 * Created by daniel on 09.03.18.
 */
public class Kata09 {

    private static final Logger LOGGER = Logger.getLogger("Kata09");

    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutServiceServiceImpl();

        checkoutService.scan(UnitType.A.name());
        checkoutService.scan(UnitType.A.name());
        checkoutService.scan(UnitType.D.name());
        checkoutService.scan(UnitType.C.name());
        checkoutService.scan(UnitType.B.name());
        LOGGER.info("CheckoutService total: " + checkoutService.total());
    }
}
