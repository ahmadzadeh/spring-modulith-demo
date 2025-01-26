package com.example.hex_modulith.payments.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.hex_modulith.payments.application.port.in.CheckoutUseCase;
import com.example.hex_modulith.payments.domain.event.PaymentStatusUpdatedEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CheckoutService implements CheckoutUseCase {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Async
    public void checkout(String orderId) {
        try {
            //TODO: Save payment using paymentStorage outPort
            applicationEventPublisher.publishEvent(new PaymentStatusUpdatedEvent(orderId,
                "Payment Started..."));
            Thread.sleep(2000);
            applicationEventPublisher.publishEvent(new PaymentStatusUpdatedEvent(orderId,
                "Waiting For 3DS Authentication..."));
            Thread.sleep(2000);
            applicationEventPublisher.publishEvent(new PaymentStatusUpdatedEvent(orderId,
                "Waiting For Bank Confirmation..."));
            Thread.sleep(1000);
            applicationEventPublisher.publishEvent(new PaymentStatusUpdatedEvent(orderId,
                "Finalizing Payment..."));
            Thread.sleep(1000);
            applicationEventPublisher.publishEvent(new PaymentStatusUpdatedEvent(orderId, "PAID"));
        } catch (InterruptedException ignored) {
        }
    }
}
