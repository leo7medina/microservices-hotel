# Arquitectura - Microservices HOTEL

Este proyecto se basa en comprender como funciona la arquitectura de microservicios con Spring Boot 3.


## Temas vistos:
- Construcción de microservicios con Spring Boot 3
- Spring Cloud
- Use de base datos H2
- Creación de imagénes y contenedores con Docker
- Configuración centralizada de microservicios

### Comandos realizados en este proyecto

#### Construir images
- docker build . -t leo7medina/hotels
- docker build . -t leo7medina/reservations
- docker build . -t leo7medina/rooms
- docker build . -t leo7medina/config-server

#### Construir contenedores
- docker run -d -p 8080:8080 --name hotels leo7medina/hotels
- docker run -d -p 8082:8082 --name reservations leo7medina/reservations
- docker run -d -p 8081:8081 --name rooms leo7medina/rooms
- docker run -d -p 8085:8085 --name config-server leo7medina/config-server

#### Generando imagen usando BuildPack
- mvn spring-boot:build-image

#### Subiendo images a DockerHub
- docker push docker.io/leo7medina/hotels
- docker push docker.io/leo7medina/reservations
- docker push docker.io/leo7medina/rooms
- docker push docker.io/leo7medina/config-server

#### Login a DockerHub
- docker login -u "usuario" -p "password" docker.io

#### Docker compose
- docker compose up