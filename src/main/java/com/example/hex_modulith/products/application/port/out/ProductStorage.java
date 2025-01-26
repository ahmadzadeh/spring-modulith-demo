package com.example.hex_modulith.products.application.port.out;

import java.util.List;

import com.example.hex_modulith.products.domain.Product;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;

public interface ProductStorage {
    List<Product> getProducts();

    boolean isAvailable(ProductSku sku, int quantity);

    Product deductQuantity(ProductSku sku, int quantityToDeduct);
}
