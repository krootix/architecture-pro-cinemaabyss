package ru.cinema.events.kafka.event;

import java.security.SecureRandom;

public enum EventType {
    USER,
    PAYMENT,
    MOVIE;

    private static final SecureRandom PRNG = new SecureRandom();

    public static EventType random()  {
        EventType[] types = values();
        return types[PRNG.nextInt(types.length)];
    }
}
