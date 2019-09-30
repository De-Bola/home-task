package com.fuel.consumption.domain;

public enum FuelType {
    NINETY_FIVE("95"),
    NINETY_EIGHT("98"),
    D("D");

    FuelType(String fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    private final String fuelTypes;

    public String getFuelTypes() {
        return fuelTypes;
    }
}
