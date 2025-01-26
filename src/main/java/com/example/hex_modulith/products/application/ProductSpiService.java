package com.example.hex_modulith.products.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hex_modulith.products.application.port.in.ProductQuerySpi;
import com.example.hex_modulith.products.application.port.out.ProductStorage;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductSpiService implements ProductQuerySpi {
    private final ProductStorage productStorage;

    @Override
    @Transactional(readOnly = true)
    public boolean isAvailable(String sku, int quantity) {
        return productStorage.isAvailable(new ProductSku(sku), quantity);
    }
}
