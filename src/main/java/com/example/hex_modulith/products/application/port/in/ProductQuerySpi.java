package com.example.hex_modulith.products.application.port.in;

import org.springframework.modulith.NamedInterface;

@NamedInterface("ProductQuerySpi")
public interface ProductQuerySpi {
    boolean isAvailable(String sku, int quantity);
}
