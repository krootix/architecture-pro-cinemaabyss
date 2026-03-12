package ru.cinema.events.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.cinema.events.dto.PaymentDto;
import ru.cinema.events.event.PaymentEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventProducer {

    @Value("${app.payment_events}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(PaymentEvent event) {
//        var paymentEvent = PaymentDto.builder()
//                .userId(dto.getUserId())
//                .paymentId(dto.getPaymentId())
//                .amount(dto.getAmount())
//                .methodType(dto.getMethodType())
//                .timestamp(dto.getTimestamp())
//                .build();

        kafkaTemplate.send(topicName, event);
        log.info("Produced message: {} to topic {}", event, topicName);
    }

}
