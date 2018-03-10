package org.hintze.application.service;

import java.math.BigDecimal;

public interface Checkout {

    Checkout newInstance();

    BigDecimal scan(String item);

    BigDecimal total();

}
