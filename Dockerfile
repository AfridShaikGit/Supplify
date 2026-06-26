FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/Supplify-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]