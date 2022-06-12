FROM openjdk:17-jdk-oracle as build
WORKDIR .

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY frontend frontend


RUN ./mvnw clean package


FROM openjdk:17-jdk-alpine as run
VOLUME /tmp
EXPOSE 8080/tcp
COPY --from=build ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]





