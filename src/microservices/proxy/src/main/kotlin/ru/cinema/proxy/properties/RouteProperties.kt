package ru.cinema.proxy.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "route-properties")
class RouteProperties {
    var movies = "http://movies-service:8081"
    var events = "http://events-service:8082"
    var monolith = "http://monolith:8080"
}