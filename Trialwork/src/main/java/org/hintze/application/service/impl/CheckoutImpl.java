package org.hintze.application.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hintze.application.service.Checkout;
import org.hintze.application.service.UnitPrice;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutImpl implements Checkout {

    private static final Logger LOGGER = Logger.getLogger("CheckoutImpl");
    private BigDecimal total = BigDecimal.ZERO;
    private Object pricingRules = new Object();//TODO hin default

    @Override
    @Deprecated
    public Checkout newInstance(final Object pricingRules) {
        this.pricingRules = pricingRules;
        return new CheckoutImpl();//TODO hin
    }

    @Override
    public BigDecimal scan(String item) {
        BigDecimal price = UnitPrice.forName(item).getPrice();
        LOGGER.info("Price: " + price);
        addItemPrice(price);
        return total;
    }

    @Override
    public BigDecimal total() {
        //TODO hin add special
        return total;
    }

    private void addItemPrice(BigDecimal itemPrice) {
        if (itemPrice != null) {
            total = total.add(itemPrice);
        }
    }
}
