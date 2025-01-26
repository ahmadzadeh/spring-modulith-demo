package com.example.hex_modulith.orders.domain;


public record Order(
    String orderId,
    String productSku,
    int quantity,
    String paymentStatus,
    boolean paid
) {
}
