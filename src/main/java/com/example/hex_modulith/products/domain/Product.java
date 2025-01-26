package com.example.hex_modulith.products.domain;

import com.example.hex_modulith.products.domain.valueobject.ProductPrice;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;

import lombok.NonNull;

public record Product(
    @NonNull ProductSku sku,
    @NonNull String name,
    @NonNull ProductPrice price
) {
}
