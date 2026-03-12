package ru.cinema.events.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentEvent {
    Long paymentId;
    Long userId;
    BigDecimal amount;
    LocalDateTime timestamp; // 2023-01-15T14:30:00Z
    String methodType;
}