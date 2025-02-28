FROM openjdk:17-jdk-slim as build

COPY target/reservations-0.0.1-SNAPSHOT.jar reservations-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "/reservations-0.0.1-SNAPSHOT.jar" ]