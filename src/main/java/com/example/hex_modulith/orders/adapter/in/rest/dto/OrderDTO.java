package com.example.hex_modulith.orders.adapter.in.rest.dto;


public record OrderDTO(
    String orderId,
    String productName,
    int quantity
) {
}
