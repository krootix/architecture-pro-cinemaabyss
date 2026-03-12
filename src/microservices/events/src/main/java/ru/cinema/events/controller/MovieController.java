package ru.cinema.events.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cinema.events.dto.MovieDto;
import ru.cinema.events.kafka.producer.MovieEventProducer;
import ru.cinema.events.mapper.MovieMapper;
import ru.cinema.events.mapper.PaymentMapper;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieEventProducer movieEventProducer;
    private final MovieMapper movieMapper;

    @PostMapping("/api/events/movie")
    public ResponseEntity<Object> createMovie(@RequestBody MovieDto dto) {
        log.info("Movie with id '{}' has been created", dto.getId());
        movieEventProducer.sendEvent(movieMapper.toEvent(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }
}
