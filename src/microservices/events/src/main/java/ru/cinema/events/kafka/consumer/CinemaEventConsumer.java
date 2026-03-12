package ru.cinema.events.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.cinema.events.dto.MovieDto;
import ru.cinema.events.dto.PaymentDto;
import ru.cinema.events.dto.UserDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class CinemaEventConsumer {

    @KafkaListener(topics = "${app.movie_events}", groupId = "events-consumer-group")
    public void listenMovie(MovieDto dto) {
        log.info("Received event: {}", dto);
    }

    @KafkaListener(topics = "${app.user_events}", groupId = "events-consumer-group")
    public void listenUser(UserDto dto) {
        log.info("Received event: {}", dto);
    }

    @KafkaListener(topics = "${app.payment_events}", groupId = "events-consumer-group")
    public void listenPayment(PaymentDto dto) {
        log.info("Received event: {}", dto);
    }

}
