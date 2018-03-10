package org.hintze.application;

import org.hintze.application.service.Checkout;
import org.hintze.application.service.UnitPrice;
import org.hintze.application.service.impl.CheckoutImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by daniel on 09.03.18.
 */
public class Kata09 {

    private static final Logger LOGGER = Logger.getLogger("Kata09");

    public static void main(String[] args) {
        Checkout checkout = new CheckoutImpl();

        checkout.scan(UnitPrice.A.name());
        checkout.scan(UnitPrice.A.name());
        checkout.scan(UnitPrice.D.name());
        checkout.scan(UnitPrice.C.name());
        checkout.scan(UnitPrice.B.name());
        LOGGER.info("Checkout total: " + checkout.total());
    }
}
