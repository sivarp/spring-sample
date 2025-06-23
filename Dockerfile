# Use Maven to build the project with proxy settings
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY .mvn ./mvn
RUN mvn -s mvn/settings.xml -q dependency:go-offline
COPY src ./src
RUN mvn -s mvn/settings.xml -q package -DskipTests

# Runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
