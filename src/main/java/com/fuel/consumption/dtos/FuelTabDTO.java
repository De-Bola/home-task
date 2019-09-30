package com.fuel.consumption.dtos;

import java.math.BigDecimal;

public class FuelTabDTO {
    private Long driverID;
    private String purchaseDate;
    private Double purchasedVolume;
    private Double unitPrice;
    private String fuelType;
    private BigDecimal amountPaid;
    private BigDecimal average;

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }
    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchasedVolume() {
        return purchasedVolume;
    }

    public void setPurchasedVolume(Double purchasedVolume) {
        this.purchasedVolume = purchasedVolume;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
