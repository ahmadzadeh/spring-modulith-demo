package com.example.hex_modulith.payments.domain.event;

import org.springframework.modulith.NamedInterface;

@NamedInterface("PaymentStatusUpdatedEvent")
public record PaymentStatusUpdatedEvent(
    String orderId,
    String paymentStatus
) {
    public boolean isPaid() {
        return "PAID".equals(paymentStatus);
    }
}
