FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY target/Museum-API-0.0.1-SNAPSHOT.jar Museums.jar
EXPOSE 8080
CMD ["java", "-jar", "Museums.jar"]