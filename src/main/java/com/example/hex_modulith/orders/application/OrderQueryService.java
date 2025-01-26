package com.example.hex_modulith.orders.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hex_modulith.orders.application.port.in.OrderQueryUseCase;
import com.example.hex_modulith.orders.application.port.out.OrderStorage;
import com.example.hex_modulith.orders.domain.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderQueryService implements OrderQueryUseCase {
    private final OrderStorage orderStorage;

    @Override
    @Transactional
    public Optional<Order> retrieveOrder(String orderId) {
        return orderStorage.findOrder(orderId);
    }
}
