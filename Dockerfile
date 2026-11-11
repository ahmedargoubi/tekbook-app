# syntax=docker/dockerfile:1

# --- Étape 1 : build (jetable) ---
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn -q dependency:go-offline -B
COPY src ./src
RUN mvn -q -DskipTests package -B

# --- Étape 2 : runtime Alpine patchée (livrée) ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN apk upgrade --no-cache
COPY --from=builder /build/target/app.jar app.jar
RUN addgroup -S app && adduser -S -G app app
USER 10001:10001
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
