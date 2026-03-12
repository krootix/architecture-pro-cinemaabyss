package ru.cinema.events.kafka.event;

import java.security.SecureRandom;

public enum EventStatus {
    RECEIVED,
    CREATE,
    PROCESS,
    END;

    private static final SecureRandom PRNG = new SecureRandom();

    public static EventStatus random()  {
        EventStatus[] statuses = values();
        return statuses[PRNG.nextInt(statuses.length)];
    }
}
