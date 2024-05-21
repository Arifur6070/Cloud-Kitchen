#Official maven image to build my app
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app


#Copying Pom.xml file
COPY pom.xml .
COPY src ./src

#Packaging the application
RUN mvn clean package -DskipTests

#OpenJDK version to run as the base image
FROM openjdk:17-jdk-slim
WORKDIR /app

#Coping the packaged application to the /app directory
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]