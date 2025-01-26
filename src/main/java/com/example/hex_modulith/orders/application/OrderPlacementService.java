package com.example.hex_modulith.orders.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hex_modulith.orders.application.port.in.OrderPlacementUseCase;
import com.example.hex_modulith.orders.application.port.out.OrderStorage;
import com.example.hex_modulith.orders.application.port.out.ProductApiInvoker;
import com.example.hex_modulith.orders.domain.Order;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderPlacementService implements OrderPlacementUseCase {
    private final ProductApiInvoker productApiInvoker;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final OrderStorage orderStorage;

    @Override
    @Transactional
    public Order placeOrder(@NonNull String productSku, int quantity) {
        if (!productApiInvoker.isAvailable(productSku, quantity)) {
            throw new IllegalArgumentException("Product is out of stock");
        }
        return orderStorage.placeOrder(productSku, quantity);
    }
}
