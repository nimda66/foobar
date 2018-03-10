package org.hintze.application.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hintze.application.service.Checkout;

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
    public BigDecimal scan(String items) {
        String[] split = StringUtils.split(items);
        LOGGER.log(Level.INFO, split[0]);
        return BigDecimal.ZERO;//TODO hin
    }

    @Override
    public BigDecimal total() {
        return total;
    }

    private void addItemPrice(BigDecimal itemPrice) {
        if (itemPrice != null) {
            total = total.add(itemPrice);
        }
    }
}
