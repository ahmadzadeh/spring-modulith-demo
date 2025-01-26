package com.example.hex_modulith.orders.application.port.out;

import java.util.List;

import com.example.hex_modulith.orders.domain.Product;

public interface ProductStorage {
    List<Product> loadAll();

    void persist(Product product);
}
