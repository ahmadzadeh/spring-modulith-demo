package com.example.hex_modulith.orders.adapter.in.rest.dto;

import lombok.NonNull;

public record OrderPayload(
    @NonNull String productSku,
    int quantity
) {

}
