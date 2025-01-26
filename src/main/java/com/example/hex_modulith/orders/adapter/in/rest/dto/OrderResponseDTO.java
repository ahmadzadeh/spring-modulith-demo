package com.example.hex_modulith.orders.adapter.in.rest.dto;

public record OrderResponseDTO(
    String orderId,
    String productName,
    int quantity,
    String paymentStatus,
    boolean isPaid
) {
}
