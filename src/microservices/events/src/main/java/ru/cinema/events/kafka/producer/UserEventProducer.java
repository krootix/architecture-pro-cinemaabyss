package ru.cinema.events.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.cinema.events.dto.UserDto;
import ru.cinema.events.event.UserEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventProducer {

    @Value("${app.user_events}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(UserEvent event) {
//        var userEvent = UserDto.builder()
//                .userId(dto.getUserId())
//                .email(dto.getEmail())
//                .action(dto.getAction())
//                .username(dto.getUsername())
//                .timestamp(dto.getTimestamp())
//                .build();

        kafkaTemplate.send(topicName, event);
        log.info("Produced message: {} to topic {}", event, topicName);
    }

}
