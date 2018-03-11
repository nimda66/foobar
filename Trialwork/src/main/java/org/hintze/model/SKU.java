package org.hintze.model;


/**
 * the checkout item
 */
public class SKU {

    private String name;

    private UnitType unitType;

    /**
     * @param name
     * @param unitType
     */
    public SKU(String name, UnitType unitType) {
        this.name = name;
        this.unitType = unitType;
    }

    public String getName() {
        return name;
    }

    public UnitType getUnitType() {
        return unitType;
    }

}
