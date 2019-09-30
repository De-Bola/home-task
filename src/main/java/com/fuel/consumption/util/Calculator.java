package com.fuel.consumption.util;

import java.math.BigDecimal;

class Calculator {
    BigDecimal multiply(Double pricePerLitre, Double purchasedVolume) {
        return BigDecimal.valueOf(pricePerLitre).multiply(BigDecimal.valueOf(purchasedVolume));
    }
}
