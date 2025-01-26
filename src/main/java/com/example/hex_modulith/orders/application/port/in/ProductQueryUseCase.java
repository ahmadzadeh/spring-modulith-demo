package com.example.hex_modulith.orders.application.port.in;

import java.util.List;

import com.example.hex_modulith.orders.domain.Product;

public interface ProductQueryUseCase {
    List<Product> findAllProducts();
}
