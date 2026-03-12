
# Stage 1: Build the application
FROM eclipse-temurin:23-jdk-alpine AS build
WORKDIR /app

# Install Gradle manually
RUN apk add --no-cache bash
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

# Make gradlew executable and build
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

# Stage 2: Create the final image
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port your Spring Boot application listens on
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
