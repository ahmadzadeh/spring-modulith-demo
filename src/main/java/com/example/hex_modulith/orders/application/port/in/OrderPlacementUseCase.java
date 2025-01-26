package com.example.hex_modulith.orders.application.port.in;


import com.example.hex_modulith.orders.domain.Order;

import lombok.NonNull;

public interface OrderPlacementUseCase {
    Order placeOrder(@NonNull String productSku, int quantity);
}
