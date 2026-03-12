package ru.cinema.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentDto {
    Long id;
    Long userId;
    BigDecimal amount;
    LocalDateTime timestamp; // 2023-01-15T14:30:00Z
}