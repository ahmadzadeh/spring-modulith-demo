package com.example.hex_modulith.orders.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hex_modulith.orders.application.port.in.ProductQueryUseCase;
import com.example.hex_modulith.orders.application.port.out.ProductStorage;

import com.example.hex_modulith.orders.domain.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductQueryService implements ProductQueryUseCase {
    private final ProductStorage productStorage;

    @Override
    public List<Product> findAllProducts() {
        return productStorage.loadAll();
    }
}
