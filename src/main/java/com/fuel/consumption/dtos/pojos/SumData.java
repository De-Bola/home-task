package com.fuel.consumption.dtos.pojos;

import java.math.BigDecimal;

public class SumData {
    private String purchaseDate;
    private BigDecimal sum;

    public SumData(String purchaseDate, BigDecimal sum) {
        this.purchaseDate = purchaseDate;
        this.sum = sum;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
