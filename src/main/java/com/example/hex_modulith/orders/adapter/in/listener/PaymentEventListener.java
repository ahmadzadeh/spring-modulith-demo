package com.example.hex_modulith.orders.adapter.in.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.hex_modulith.orders.application.port.out.OrderStorage;
import com.example.hex_modulith.orders.domain.Order;
import com.example.hex_modulith.payments.domain.event.PaymentStatusUpdatedEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaymentEventListener {
    private final OrderStorage orderStorage;
    private final OrderMapper orderMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final TransactionTemplate transactionTemplate;

    @Async
    @EventListener
    public void onPaymentStatusUpdated(PaymentStatusUpdatedEvent event) {
        transactionTemplate.executeWithoutResult((status) -> {
            Order confirmedOrder = orderStorage.updatePaymentStatus(event.orderId(), event.paymentStatus(), event.isPaid());
            if (confirmedOrder.paid()) {
                applicationEventPublisher.publishEvent(orderMapper.toOrderCompletedEvent(confirmedOrder));
            }
        });
    }
}
