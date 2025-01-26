package com.example.hex_modulith.orders.adapter.out.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.hex_modulith.orders.application.port.out.OrderStorage;
import com.example.hex_modulith.orders.domain.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderJpaStorage implements OrderStorage {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderJpaMapper orderJpaMapper;

    @Override
    public Order placeOrder(String productSku, int quantity) {
        var jpaEntity = new OrderJpaEntity();
        jpaEntity.setOrderId(UUID.randomUUID().toString());
        jpaEntity.setProductSku(productSku);
        jpaEntity.setQuantity(quantity);
        jpaEntity.setPaymentStatus("Not Started");
        return orderJpaMapper.toOrderDomainModel(orderJpaRepository.save(jpaEntity));
    }

    @Override
    public Order updatePaymentStatus(String orderId, String newPaymentStatus, boolean isPaid) {
        var order = orderJpaRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        order.setPaymentStatus(newPaymentStatus);
        order.setPaid(isPaid);
        return orderJpaMapper.toOrderDomainModel(orderJpaRepository.save(order));
    }

    @Override
    public Optional<Order> findOrder(String orderId) {
        return orderJpaRepository.findById(orderId)
            .map(orderJpaMapper::toOrderDomainModel);
    }
}
