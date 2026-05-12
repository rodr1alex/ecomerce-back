# Stage 1: compilar con Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests clean package

# Stage 2: imagen de runtime liviana
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/users-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
