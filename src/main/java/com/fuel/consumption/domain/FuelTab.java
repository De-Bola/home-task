package com.fuel.consumption.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class FuelTab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Driver Id cannot be null")
    private Long driverID;
    private String monthAndYear;
    @NotNull(message = "Date fields cannot be null")
    private LocalDate purchaseDate;
    @Min(value = 1)
    private Double purchasedVolume;
    @Min(value = 1)
    private Double unitPrice;
    @NotBlank(message = "Fuel type cannot be null")
    private String fuelType;
    private BigDecimal amountPaid;
    @Enumerated(EnumType.STRING)
    private Currencies currency;
    @Enumerated(EnumType.STRING)
    private Measurements measurement;

    public FuelTab() {
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public Measurements getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurements measurement) {
        this.measurement = measurement;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
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
}
