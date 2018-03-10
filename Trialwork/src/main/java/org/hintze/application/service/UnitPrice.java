package org.hintze.application.service;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * the standard prices
 */
public enum UnitPrice {
    ZERO(BigDecimal.ZERO),
    A(BigDecimal.valueOf(50)),
    B(BigDecimal.valueOf(30)),
    C(BigDecimal.valueOf(20)),
    D(BigDecimal.valueOf(15));

    private final BigDecimal unitPrice;

    UnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @param name
     * @return ZERO on undefined name
     */
    public static UnitPrice forName(String name) {
        if (StringUtils.isBlank(name)) {
            return ZERO;
        }
        return Arrays.stream(UnitPrice.values()).filter(v -> v.name().equals(name)).findFirst().get();
    }

    public BigDecimal getPrice() {
        return unitPrice;
    }
}
