package com.example.hex_modulith.orders.adapter.out;

import org.springframework.stereotype.Component;

import com.example.hex_modulith.orders.application.port.out.ProductApiInvoker;
import com.example.hex_modulith.products.application.port.in.ProductQuerySpi;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProductModuleApiInvoker implements ProductApiInvoker {
    private final ProductQuerySpi productQuerySpi;

    @Override
    public boolean isAvailable(String productSku, int quantity) {
        // This can be a REST call to the product module if product module is a separate service
        return productQuerySpi.isAvailable(productSku, quantity);
    }
}
