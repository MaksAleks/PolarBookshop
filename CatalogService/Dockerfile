# syntax=docker/dockerfile:1
FROM gradle:7.2.0-jdk17-alpine AS builder
WORKDIR /workspace/app

ARG REGISTRY_TOKEN
COPY src src
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY gradle.properties gradle.properties

RUN --mount=type=cache,target=/root/.gradle REGISTRY_TOKEN=${REGISTRY_TOKEN} gradle build -x test -x integTest
RUN mkdir -p build/libs/extracted && java -Djarmode=layertools -jar build/libs/*.jar extract --destination build/libs/extracted

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG EXTRACTED=/workspace/app/build/libs/extracted
COPY --link --from=builder ${EXTRACTED}/dependencies/ ./
COPY --link --from=builder ${EXTRACTED}/spring-boot-loader/ ./
COPY --link --from=builder ${EXTRACTED}/snapshot-dependencies/ ./
COPY --link --from=builder ${EXTRACTED}/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]