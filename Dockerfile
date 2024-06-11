FROM maven:3.8.7-openjdk-17 AS build
COPY ../.. .
RUN mvn -B clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Capstone-1.0-SNAPSHOT.jar Capstone.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Capstone.jar"]