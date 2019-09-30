package com.fuel.consumption.dao.dtos;

public class MonthlyStatsDTO {

    private String fuelType;
    private String purchasedVolume;
    private String averagePrice;
    private String sum;
    private String monthAndYear;

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getPurchasedVolume() {
        return purchasedVolume;
    }

    public void setPurchasedVolume(String purchasedVolume) {
        this.purchasedVolume = purchasedVolume;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
