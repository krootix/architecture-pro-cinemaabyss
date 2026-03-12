package ru.cinema.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieDto {
    Long id;
    String title;
    String description;
    List<String> genres;
    Double rating;
}