FROM openjdk:17-jdk-slim as build

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar

EXPOSE 8065

ENTRYPOINT [ "java", "-jar", "/eurekaserver-0.0.1-SNAPSHOT.jar" ]