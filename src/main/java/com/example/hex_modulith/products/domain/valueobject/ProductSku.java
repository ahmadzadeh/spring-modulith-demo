package com.example.hex_modulith.products.domain.valueobject;

import org.jmolecules.ddd.annotation.ValueObject;

import lombok.NonNull;

@ValueObject
public record ProductSku(@NonNull String value) {
    public ProductSku {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Product SKU must not be blank");
        }
        value = value.toUpperCase();
    }

    @Override
    public String toString() {
        return value;
    }
}
