# Arquitectura - Microservices HOTEL

Este proyecto se basa en comprender como funciona la arquitectura de microservicios con Spring Boot 3.


## Temas vistos:
- Construcción de microservicios con Spring Boot 3
- Spring Cloud
- Uso de base datos H2
- Creación de imagénes y contenedores con Docker
- Configuración centralizada de microservicios
- Registro y descubrimiento de microservicios
- RestTemplate y Feing para comunicación entre microservicios
- Resilencia y tolerancia a fallos con Resilience4j
  - Patron Circuit Breaker
  - Metodo fallbackMethod
  - Patron retry
- Spring Cloud Gateway
- Trazabilidad distribuida en microservicios
  - Sleuth
  - Zipkin
- Seguridad de microservicios con OAuth 2
  - Keycloak

### Comandos realizados en este proyecto

#### Construir images
- docker build . -t leo7medina/hotels
- docker build . -t leo7medina/reservations
- docker build . -t leo7medina/rooms
- docker build . -t leo7medina/configserver
- docker build . -t leo7medina/eurekaserver
- docker build . -t leo7medina/gatewayserver

#### Construir contenedores
- docker run -d -p 8080:8080 --name hotels leo7medina/hotels
- docker run -d -p 8082:8082 --name reservations leo7medina/reservations
- docker run -d -p 8081:8081 --name rooms leo7medina/rooms
- docker run -d -p 8085:8085 --name config-server leo7medina/config-server
- docker run -d -p 8065:8065 --name eureka-server -e DEUREKA_HOSTNAME=eureka-server leo7medina/eureka-server

- --network leo-dev-demo-network

#### Generando imagen usando BuildPack
- mvn spring-boot:build-image

#### Subiendo images a DockerHub
- docker push docker.io/leo7medina/hotels
- docker push docker.io/leo7medina/reservations
- docker push docker.io/leo7medina/rooms
- docker push docker.io/leo7medina/configserver
- docker push docker.io/leo7medina/eurekaserver
- docker push docker.io/leo7medina/gatewayserver

#### Login a DockerHub
- docker login -u "usuario" -p "password" docker.io

#### Docker compose
- docker compose up


### Apagado de microservicios
Metodo POST
- http://192.168.0.103:8080/actuator/shutdown
- http://192.168.0.103:8081/actuator/shutdown
- http://192.168.0.103:8082/actuator/shutdown

### Saltar test
-Dmaven.test.skip=true

### Zipkint con docker
- docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin

### Keycloak with docker
- docker run -d -p 8889:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin —name keycloak -v v_keycloak-data:/opt/keycloak/data keycloak/keycloak:latest start-dev
