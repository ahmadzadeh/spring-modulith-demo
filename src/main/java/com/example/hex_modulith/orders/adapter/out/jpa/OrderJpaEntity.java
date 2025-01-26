package com.example.hex_modulith.orders.adapter.out.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    private String orderId;

    @Column(nullable = false)
    private String productSku;

    private int quantity;

    @Column(nullable = false)
    private String paymentStatus;

    private boolean paid;
}
