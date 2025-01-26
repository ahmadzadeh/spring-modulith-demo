package com.example.hex_modulith.orders.adapter.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hex_modulith.orders.adapter.in.rest.dto.ProductDTO;
import com.example.hex_modulith.orders.adapter.in.rest.mapper.ProductMapper;
import com.example.hex_modulith.orders.application.port.in.ProductQueryUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductQueryUseCase productProvider;
    private final ProductMapper productMapper;

    @GetMapping("/order/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return new ResponseEntity<>(productProvider.findAllProducts().stream()
            .map(productMapper::toProductDTO)
            .toList(), HttpStatus.OK);
    }
}
