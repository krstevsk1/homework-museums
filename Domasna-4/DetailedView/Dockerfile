FROM openjdk:17-jdk-alpine
WORKDIR /details_app
ARG JAR_FILE=target/*.jar
COPY target/DetailedView-0.0.1-SNAPSHOT.jar Details.jar
EXPOSE 8082
CMD ["java", "-jar", "Details.jar"]