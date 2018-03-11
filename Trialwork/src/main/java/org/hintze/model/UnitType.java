package org.hintze.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * the standard prices in cent
 */
public enum UnitType {
    ZERO(0),
    A(50),
    B(30),
    C(20),
    D(15);

    private final int unitPrice;

    UnitType(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @param name
     * @return ZERO on undefined name
     */
    public static UnitType forName(String name) {
        if (StringUtils.isBlank(name)) {
            return ZERO;
        }
        return Arrays.stream(UnitType.values()).filter(v -> v.name().equals(name)).findFirst().get();
    }

    public int getPrice() {
        return unitPrice;
    }
}
