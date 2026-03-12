package ru.cinema.proxy.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.ResourceHandlerRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
@EnableWebFlux
class WebConfig : WebFluxConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        // Не добавляем обработчики для корневого пути
        registry.addResourceHandler("/static/**")  // Только явный путь /static/
            .addResourceLocations("classpath:/static/")
    }
}