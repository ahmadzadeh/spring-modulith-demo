package com.example.hex_modulith.products.domain.valueobject;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record ProductPrice(float price, String currency) {
    public ProductPrice {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
        if (currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be blank");
        }
        currency = currency.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", price, currency);
    }
}
