package com.fuel.consumption.dtos.pojos;

import java.time.LocalDate;

public class MonthlyStats {

    private String fuelType;
    private Double purchasedVolume;
    private Double averagePrice;
    private Double sum;
    private LocalDate purchaseDate;

    public MonthlyStats(String fuelType, Double purchasedVolume, Double averagePrice, Double sum, LocalDate purchaseDate) {
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
