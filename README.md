# spring-sample

This project demonstrates a simple Spring Boot application packaged as a WAR file. It now targets Spring Boot 3 and Java 21 and includes a small example of a digital book library backed by MongoDB.

## Running

Configure a MongoDB instance (default `mongodb://localhost:27017/bookdb`) or adjust `application.properties`. Build and run the application using Maven:

```bash
mvn spring-boot:run
```

The REST endpoints for managing books are exposed under `/books`.

## Docker

You can also run the application with a local MongoDB using Docker Compose:

```bash
docker compose up --build
```

This exposes the application on port `8080` and MongoDB on `27017`.
