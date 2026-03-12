package ru.cinema.events.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cinema.events.dto.UserDto;
import ru.cinema.events.kafka.producer.UserEventProducer;
import ru.cinema.events.mapper.UserMapper;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserEventProducer userEventProducer;
    private final UserMapper userMapper;

    @PostMapping("/api/events/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDto dto) {
        log.info("User with email '{}' has been created", dto.getEmail());
        userEventProducer.sendEvent(userMapper.toEvent(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }
}
