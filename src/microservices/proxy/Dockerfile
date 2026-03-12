# Stage 1: Build the application
FROM eclipse-temurin:23-jdk-alpine AS build
WORKDIR /app

# Install required packages
RUN apk add --no-cache bash curl

# Copy Gradle files
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

# Fix line endings if needed (important for Windows)
RUN sed -i 's/\r$//' gradlew && \
    chmod +x gradlew

# Download gradle wrapper jars if missing
RUN ./gradlew --version

# Build the application
RUN ./gradlew bootJar --no-daemon

# Stage 2: Create the final image
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app

# Copy the built JAR
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]