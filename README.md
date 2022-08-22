# spring-boot-mongodb
Projeto para estudo de uso do MongoDB com Spring

# Requisitos 
- Docker 2+
- Docker-compose 
- Java 17
- Maven 3+
- GIT

# Start mongodb image

docker run --name mongodbjoao -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=joao -e MONGO_INITDB_ROOT_PASSWORD=12345 mongo
