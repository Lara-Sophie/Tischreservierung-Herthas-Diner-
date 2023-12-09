# Build stage
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle /home/gradle/src /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
LABEL org.name="Lara-Sophie/Paul"

# Package stage
FROM eclipse-temurin:jdk17-jammy
COPY --from=build /home/gradle/src/build/libs/Tischreservierung-Herthas-Diner-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
