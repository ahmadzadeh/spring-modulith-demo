package com.example.hex_modulith.orders.adapter.out.jpa;

import org.mapstruct.Mapper;

import com.example.hex_modulith.orders.domain.Order;

@Mapper(componentModel = "spring")
public interface OrderJpaMapper {
    Order toOrderDomainModel(OrderJpaEntity orderJpaEntity);
}
