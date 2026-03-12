package ru.cinema.events.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HealthController {

    @GetMapping("/api/events/health")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> checkHealthStatus() {
        log.info("Health status has been checked. Service is up");
        return ResponseEntity.ok(Map.of("status", true));
    }
}
