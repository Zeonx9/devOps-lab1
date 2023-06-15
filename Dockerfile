FROM maven:3.8.5-openjdk-17 AS build

COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /application
COPY --from=build ./target/*.jar ./application/lab.jar
ENTRYPOINT ["java","-Dfile.encoding=UTF8", "-jar","./application/lab.jar"]