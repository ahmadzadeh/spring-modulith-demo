package com.example.hex_modulith.orders.domain;

import lombok.NonNull;

public record Product(
    @NonNull String sku,
    @NonNull String name,
    @NonNull String price
) {
}
