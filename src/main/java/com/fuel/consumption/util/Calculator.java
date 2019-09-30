package com.fuel.consumption.util;

import java.math.BigDecimal;

public class Calculator {
    public BigDecimal multiply(Double pricePerLitre, Double purchasedVolume) {
        return BigDecimal.valueOf(pricePerLitre).multiply(BigDecimal.valueOf(purchasedVolume));
    }
}
