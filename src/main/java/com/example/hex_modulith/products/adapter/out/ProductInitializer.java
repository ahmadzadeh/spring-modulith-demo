package com.example.hex_modulith.products.adapter.out;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.hex_modulith.products.adapter.out.jpa.ProductJpaEntity;
import com.example.hex_modulith.products.adapter.out.jpa.ProductJpaRepository;
import com.example.hex_modulith.products.domain.valueobject.ProductPrice;
import com.example.hex_modulith.shared.event.ProductCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductInitializer {
    private final ProductJpaRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeProducts() {
        List<ProductJpaEntity> initialProducts = productRepository.saveAll(
            List.of(
                new ProductJpaEntity(null, "LAPTOP123", "Dell XPS 13", 1199.99f, "USD", 50),
                new ProductJpaEntity(null, "HEADPH001", "Sony WH-1000XM5 Headphones", 399.99f, "USD", 200),
                new ProductJpaEntity(null, "PHONE202", "iPhone 15 Pro", 999.99f, "USD", 100),
                new ProductJpaEntity(null, "TVOLED77", "LG OLED C2 77-inch TV", 2499.99f, "USD", 30),
                new ProductJpaEntity(null, "CAMERA345", "Canon EOS R6", 2499.00f, "USD", 40),
                new ProductJpaEntity(null, "WATCH789", "Samsung Galaxy Watch 6", 349.99f, "USD", 150),
                new ProductJpaEntity(null, "TABLET001", "iPad Pro 11-inch", 799.99f, "USD", 120),
                new ProductJpaEntity(null, "DRONE101", "DJI Mini 3 Pro", 759.99f, "USD", 60)
            )
        );

        initialProducts.stream().map(p -> new ProductCreatedEvent(
            p.getSku(),
            p.getName(),
            new ProductPrice(p.getPrice(), p.getCurrency()).toString()
        )).forEach(applicationEventPublisher::publishEvent);

        System.out.println("Initial product data has been added to the database.");
    }
}
