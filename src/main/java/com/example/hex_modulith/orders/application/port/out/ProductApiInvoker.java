package com.example.hex_modulith.orders.application.port.out;

public interface ProductApiInvoker {
    boolean isAvailable(String productSku, int quantity);
}
