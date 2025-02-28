# Microservices HOTEL

### comandos docker
- docker build . -t leo7medina/hotels
- docker build . -t leo7medina/reservations
- docker build . -t leo7medina/rooms

docker run -d -p 8080:8080 --name hotels leo7medina/hotels
docker run -d -p 8082:8082 --name reservations leo7medina/reservations
docker run -d -p 8081:8081 --name rooms leo7medina/rooms

### BuildPack
mvn spring-boot:build-image

### Subiendo images a dockerhub

docker push docker.io/leo7medina/hotels
docker push docker.io/leo7medina/reservations
docker push docker.io/leo7medina/rooms


docker login -u "usuario" -p "password" docker.io


### Docker compose

docker compose up