package com.fuel.consumption.dtos.pojos;

import java.math.BigDecimal;

public class MonthlyStats {

    private String fuelType;
    private Double purchasedVolume;
    private Double averagePrice;
    private BigDecimal sum;
    private String purchaseDate;

    public MonthlyStats(String fuelType, Double purchasedVolume, Double averagePrice, BigDecimal sum, String purchaseDate) {
        this.fuelType = fuelType;
        this.purchasedVolume = purchasedVolume;
        this.averagePrice = averagePrice;
        this.sum = sum;
        this.purchaseDate = purchaseDate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getPurchasedVolume() {
        return purchasedVolume;
    }

    public void setPurchasedVolume(Double purchasedVolume) {
        this.purchasedVolume = purchasedVolume;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
