package org.hintze.application;

import org.hintze.model.UnitType;
import org.hintze.service.Checkout;
import org.hintze.service.impl.CheckoutImpl;

import java.util.logging.Logger;

/**
 * Created by daniel on 09.03.18.
 */
public class Kata09 {

    private static final Logger LOGGER = Logger.getLogger("Kata09");

    public static void main(String[] args) {
        Checkout checkout = new CheckoutImpl();

        checkout.scan(UnitType.A.name());
        checkout.scan(UnitType.A.name());
        checkout.scan(UnitType.D.name());
        checkout.scan(UnitType.C.name());
        checkout.scan(UnitType.B.name());
        LOGGER.info("Checkout total: " + checkout.total());
    }
}
