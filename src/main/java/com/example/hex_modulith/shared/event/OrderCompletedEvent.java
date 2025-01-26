package com.example.hex_modulith.shared.event;

public record OrderCompletedEvent(
    String orderId,
    String productSku,
    int quantity
) {
}
