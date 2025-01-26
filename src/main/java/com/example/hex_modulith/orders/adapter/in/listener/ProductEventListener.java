package com.example.hex_modulith.orders.adapter.in.listener;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.example.hex_modulith.orders.application.port.out.ProductStorage;
import com.example.hex_modulith.orders.domain.Product;
import com.example.hex_modulith.shared.event.ProductCreatedEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProductEventListener {
    private final ProductStorage productStorage;

    @ApplicationModuleListener
    public void onProductCreatedEvent(ProductCreatedEvent event) {
        productStorage.persist(new Product(event.sku(), event.name(), event.price()));
    }
}
