package com.fuel.consumption.dao.dtos;

import java.time.LocalDate;

public class ConsumptionRecordDTO {

    private String fuelType;
    private String purchasedVolume;
    private LocalDate purchaseDate;
    private String unitPrice;
    private String amountPaid;
    private Long driverID;

    public String getPurchasedVolume() {
        return purchasedVolume;
    }

    public void setPurchasedVolume(String purchasedVolume) {
        this.purchasedVolume = purchasedVolume;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }
}
