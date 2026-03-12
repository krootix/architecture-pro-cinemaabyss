package ru.cinema.events.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cinema.events.dto.PaymentDto;
import ru.cinema.events.kafka.producer.PaymentEventProducer;
import ru.cinema.events.mapper.PaymentMapper;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentEventProducer paymentEventProducer;
    private final PaymentMapper paymentMapper;

    @PostMapping("/api/events/payment")
    public ResponseEntity<Object> createPayment(@RequestBody PaymentDto dto) {
        log.info("Payment with id '{}' has been created", dto.getId());
        paymentEventProducer.sendEvent(paymentMapper.toEvent(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }
}
