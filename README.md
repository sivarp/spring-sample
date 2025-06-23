# spring-sample

This project provides a small Spring Boot library for managing books stored in MongoDB. It targets Spring Boot 3 and Java 21.

## Usage

Add this project as a dependency to gain the `Book` model, repository and REST controller. Configure a MongoDB instance (default `mongodb://localhost:27017/bookdb`) via `application.properties`.

## Building

Use Maven to build the library:

```bash
mvn package
```

Maven may need proxy settings to resolve dependencies. This repository provides
`.mvn/settings.xml` configured for a proxy at `proxy:8080`; use it with
`mvn -s .mvn/settings.xml` if required. The same settings are used by the
`Dockerfile` and `Jenkinsfile` so that builds succeed without additional
configuration.

Tests run with an embedded Spring context and do not require MongoDB.

## Docker

To try the library as a standalone application with MongoDB, use Docker Compose:

```bash
docker compose up --build
```

The container image is built using the provided `Dockerfile` and listens on
port `8080`.
