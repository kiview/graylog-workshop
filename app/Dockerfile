FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build

# -----------------------------

FROM openjdk:8-jre-slim

EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/demo.jar
WORKDIR /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "demo.jar"]