package com.fuel.consumption.dtos.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConsumptionRecord {

    private String fuelType;
    private Double purchasedVolume;
    private LocalDate purchaseDate;
    private Double unitPrice;
    private BigDecimal amountPaid;
    private Long driverID;

    public ConsumptionRecord(String fuelType, Double purchasedVolume, LocalDate purchaseDate, Double unitPrice,
                             BigDecimal amountPaid, Long driverID) {
        this.fuelType = fuelType;
        this.purchasedVolume = purchasedVolume;
        this.purchaseDate = purchaseDate;
        this.unitPrice = unitPrice;
        this.amountPaid = amountPaid;
        this.driverID = driverID;
    }

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
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

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }
}
