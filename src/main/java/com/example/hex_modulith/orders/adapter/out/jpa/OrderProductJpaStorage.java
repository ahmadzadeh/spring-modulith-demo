package com.example.hex_modulith.orders.adapter.out.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hex_modulith.orders.application.port.out.ProductStorage;
import com.example.hex_modulith.orders.domain.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderProductJpaStorage implements ProductStorage {
    private final OrderProductJpaRepository productRepository;

    @Override
    public List<Product> loadAll() {
        return productRepository.findAll().stream()
            .map(productEntity -> new Product(
                productEntity.getSku(),
                productEntity.getName(),
                productEntity.getPrice()
            ))
            .toList();
    }

    @Override
    public void persist(Product product) {
        productRepository.save(new OrderProductJpaEntity(
            null,
            product.sku(),
            product.name(),
            product.price()
        ));
    }
}
