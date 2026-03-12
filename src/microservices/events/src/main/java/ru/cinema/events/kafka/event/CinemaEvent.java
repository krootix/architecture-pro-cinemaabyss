package ru.cinema.events.kafka.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaEvent {

    private final Long id;
    private final EventType eventType;
    private final EventStatus eventStatus;
}
