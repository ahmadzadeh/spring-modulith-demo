package com.example.hex_modulith.orders.adapter.in.listener;

import org.mapstruct.Mapper;

import com.example.hex_modulith.orders.domain.Order;
import com.example.hex_modulith.shared.event.OrderCompletedEvent;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default OrderCompletedEvent toOrderCompletedEvent(Order order) {
        return new OrderCompletedEvent(
            order.orderId(),
            order.productSku(),
            order.quantity()
        );
    }
}
