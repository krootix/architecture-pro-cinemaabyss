plugins {
    kotlin("jvm") version "2.1.20"  // последняя стабильная версия Kotlin 2.1.x
    kotlin("plugin.spring") version "2.1.20"
    id("org.springframework.boot") version "3.4.2"  // новая версия Spring Boot
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "2.1.20"
}

group = "ru.cinema"
version = "1.0-SNAPSHOT"
description = "proxy"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("io.github.oshai:kotlin-logging-jvm:7.0.14")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.16")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2024.0.0")
    }
}

kotlin {
    jvmToolchain(23)
}

tasks.test {
    useJUnitPlatform()
}