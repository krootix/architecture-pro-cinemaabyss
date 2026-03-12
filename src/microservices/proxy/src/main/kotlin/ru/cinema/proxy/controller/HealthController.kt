package ru.cinema.proxy.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    private val log = KotlinLogging.logger {}

    @GetMapping("/health")
    fun checkHealthStatus(): ResponseEntity<Unit> {
        log.info { "Health status has been checked. Service is up" }
        return ResponseEntity.ok().build()
    }

}