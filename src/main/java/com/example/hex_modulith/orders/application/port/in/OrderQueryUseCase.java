package com.example.hex_modulith.orders.application.port.in;

import java.util.Optional;

import com.example.hex_modulith.orders.domain.Order;

public interface OrderQueryUseCase {
    Optional<Order> retrieveOrder(String orderId);
}
