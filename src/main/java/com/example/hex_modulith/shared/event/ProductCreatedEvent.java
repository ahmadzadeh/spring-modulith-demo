package com.example.hex_modulith.shared.event;

public record ProductCreatedEvent(
    String sku,
    String name,
    String price
) {
}
