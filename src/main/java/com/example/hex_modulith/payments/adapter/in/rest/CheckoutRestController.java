package com.example.hex_modulith.payments.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.hex_modulith.payments.application.port.in.CheckoutUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CheckoutRestController {
    private final CheckoutUseCase checkoutUseCase;

    @GetMapping("/checkout/{orderId}")
    public ResponseEntity<String> checkout(@PathVariable String orderId) {
        checkoutUseCase.checkout(orderId);
        return ResponseEntity.ok("Please wait...");
    }
}
