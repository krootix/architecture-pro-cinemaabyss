package ru.cinema.events.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserEvent {
    Long userId;
    String username;
    String email;
    String action;
    LocalDateTime timestamp; // 2023-01-15T14:30:00Z
}