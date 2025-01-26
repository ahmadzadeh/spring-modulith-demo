package com.example.hex_modulith.orders.adapter.in.rest.mapper;

import org.mapstruct.Mapper;

import com.example.hex_modulith.orders.adapter.in.rest.dto.OrderResponseDTO;
import com.example.hex_modulith.orders.domain.Order;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {
    OrderResponseDTO toOrderResponseDTO(Order order);
}
