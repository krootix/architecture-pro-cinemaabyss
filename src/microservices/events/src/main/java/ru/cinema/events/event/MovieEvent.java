package ru.cinema.events.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieEvent {
    Long movieId;
    String title;
    String action;
    Long userId;
    Double rating;
    List<String> genres;
    String description;
}