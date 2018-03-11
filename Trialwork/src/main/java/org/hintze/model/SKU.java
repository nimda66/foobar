package org.hintze.model;


public class SKU {

    private String name;

    private UnitType unitType;

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

    public int getPrice() {
        return this.getUnitType().getPrice();
    }
}
