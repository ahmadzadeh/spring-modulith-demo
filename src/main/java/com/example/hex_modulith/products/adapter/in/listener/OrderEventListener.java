package com.example.hex_modulith.products.adapter.in.listener;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.example.hex_modulith.products.application.port.out.ProductStorage;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;
import com.example.hex_modulith.shared.event.OrderCompletedEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderEventListener {
    private final ProductStorage productStorage;

    @ApplicationModuleListener
    public void handleOrderEvent(OrderCompletedEvent event) {
        productStorage.deductQuantity(new ProductSku(event.productSku()), event.quantity());
    }
}
