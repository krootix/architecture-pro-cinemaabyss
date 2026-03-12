package ru.cinema.proxy.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "traffic-properties")
class TrafficProperties {
    // Getters and setters
    var percentage = 10
    var gradualMigration = true

}