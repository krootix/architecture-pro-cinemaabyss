package ru.cinema.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    Long id;
    String username;
    String email;
}