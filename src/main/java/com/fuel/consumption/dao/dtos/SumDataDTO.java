package com.fuel.consumption.dao.dtos;

import java.math.BigDecimal;

public class SumDataDTO {
    private String monthAndYear;
    private BigDecimal sum;

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
