package ru.cinema.events.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.cinema.events.dto.MovieDto;
import ru.cinema.events.event.MovieEvent;
import ru.cinema.events.event.PaymentEvent;
import ru.cinema.events.event.UserEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieEventProducer {

    @Value("${app.movie_events}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(MovieEvent event) {
//        var movieEvent = MovieDto.builder()
//                .userId(dto.getUserId())
//                .movieId(dto.getMovieId())
//                .action(dto.getAction())
//                .description(dto.getDescription())
//                .genres(dto.getGenres())
//                .rating(dto.getRating())
//                .build();

        kafkaTemplate.send(topicName, event);
        log.info("Produced message: {} to topic {}", event, topicName);
    }

}
