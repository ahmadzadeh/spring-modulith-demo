package com.example.hex_modulith.products.adapter.out.jpa;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.hex_modulith.products.application.port.out.ProductStorage;
import com.example.hex_modulith.products.domain.Product;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProductJpaStorage implements ProductStorage {
    private final ProductJpaRepository productRepository;
    private final ProductJpaMapper productMapper;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(productMapper::jpaToDomain).toList();
    }

    @Override
    public boolean isAvailable(ProductSku sku, int quantity) {
        return productRepository.isAvailable(sku.toString(), quantity);
    }

    @Override
    @Transactional
    public Product deductQuantity(ProductSku sku, int quantityToDeduct) {
        var product = productRepository.findBySku(sku.toString()).orElseThrow(EntityNotFoundException::new);
        if (product.getQuantity() < quantityToDeduct) {
            throw new IllegalArgumentException("Not enough quantity to deduct");
        }
        product.setQuantity(product.getQuantity() - quantityToDeduct);
        return productMapper.jpaToDomain(productRepository.save(product));
    }
}
