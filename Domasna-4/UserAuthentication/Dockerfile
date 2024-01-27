FROM openjdk:17-jdk-alpine
WORKDIR /auth_app
ARG JAR_FILE=target/*.jar
COPY target/UserAuthentication-0.0.1-SNAPSHOT.jar Authentication.jar
EXPOSE 8081
CMD ["java", "-jar", "Authentication.jar"]