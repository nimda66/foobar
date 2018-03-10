package org.hintze.application.service.impl;

import org.hintze.application.service.Checkout;

import java.math.BigDecimal;

public class CheckoutImpl implements Checkout {

    private BigDecimal total = BigDecimal.ZERO;

    @Override
    public Checkout newInstance() {
        return new CheckoutImpl();//TODO hin
    }

    @Override
    public BigDecimal scan(String item) {
        return null;
    }

    @Override
    public BigDecimal total() {
        return total;
    }

    private void addItemPrice(BigDecimal itemPrice){
        if (itemPrice!= null) {
            total = total.add(itemPrice);
        }
    }
}
