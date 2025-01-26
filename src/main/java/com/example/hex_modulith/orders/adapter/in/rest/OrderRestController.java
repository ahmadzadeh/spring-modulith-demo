package com.example.hex_modulith.orders.adapter.in.rest;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.hex_modulith.orders.adapter.in.rest.dto.OrderPayload;
import com.example.hex_modulith.orders.adapter.in.rest.dto.OrderResponseDTO;
import com.example.hex_modulith.orders.adapter.in.rest.mapper.OrderResponseMapper;
import com.example.hex_modulith.orders.application.port.in.OrderPlacementUseCase;
import com.example.hex_modulith.orders.application.port.in.OrderQueryUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrderRestController {
    private final OrderPlacementUseCase orderPlacementUseCase;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderQueryUseCase orderQueryUseCase;

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderPayload payload) {
        return new ResponseEntity<>(
            orderResponseMapper.toOrderResponseDTO(
                orderPlacementUseCase.placeOrder(payload.productSku(), payload.quantity())
            ),
            HttpStatus.CREATED
        );
    }

    @GetMapping(value = "/order/{orderId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getPaymentStatus(@PathVariable String orderId) {
        SseEmitter emitter = new SseEmitter(10_000L);
        emitter.onTimeout(emitter::complete);
        CompletableFuture.runAsync(() -> {
            boolean emitterCompleted = false;
            try {
                for (int i = 0; i < 10; i++) {
                    var order = orderQueryUseCase.retrieveOrder(orderId);
                    if (order.isEmpty()) {
                        emitter.completeWithError(new RuntimeException("Order not found"));
                        return;
                    }
                    emitter.send(SseEmitter.event()
                        .name("payment-status-update")
                        .data(order.get().paymentStatus()));

                    if (order.get().paid()) {
                        emitter.send(SseEmitter.event().name("paid").data(""));
                        break;
                    }

                    Thread.sleep(1000);
                }

                if (!emitterCompleted) {
                    emitter.complete();
                }
            } catch (Exception e) {
                if (!emitterCompleted) {
                    emitter.completeWithError(e);
                }
            }
        });


        return emitter;
    }
}
