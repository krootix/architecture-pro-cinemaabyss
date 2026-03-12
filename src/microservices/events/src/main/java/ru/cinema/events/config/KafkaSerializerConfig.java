package ru.cinema.events.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class KafkaSerializerConfig {

    private final ObjectMapper objectMapper;

    public KafkaSerializerConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public JacksonJsonSerializer<Object> customJsonSerializer() {
        return new JacksonJsonSerializer<>();
    }
}
