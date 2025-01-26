package com.example.hex_modulith.orders.application.port.out;

import java.util.Optional;

import com.example.hex_modulith.orders.domain.Order;

public interface OrderStorage {
    Order placeOrder(String productSku, int quantity);

    Order updatePaymentStatus(String orderId, String newPaymentStatus, boolean isPaid);

    Optional<Order> findOrder(String orderId);
}
