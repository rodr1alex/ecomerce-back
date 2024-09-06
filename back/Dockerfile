FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/users-backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} tienda_app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","tienda_app.jar"]
