# Cheeseria

Simple Full-Stack Application based on SpringBoot and VueJS

#### Prerequisites

make sure you have java 11 or higher installed

**for frontend development node js 17+ is also needed

#### Architecture

##### Backend

- backed-end is based on [spring-boot framework](https://spring.io/projects/spring-boot)
- written is Kotlin programming language
- model, view and controller pattern
- [kotest](https://kotest.io/) framework is used for testing

##### Frontend

- front-end is built using the latest version of [Vue JS ](https://vuejs.org/)and
- written in TypeScript language
- [JestJS](https://jestjs.io/) framework is used for testing


#### How to build and run

Compile, build and run tests for both backend and frontend via command line

```bash
./mvnw clean package
```

##### Run Application

```bash
./mvnw spring-boot:run
```

Application should run on http://localhost:8080/

##### Build & Run Application with Docker multi-stage build

```bash
    docker build --target build -t openjdk17-jdk-oracle_build .
    docker build --target run -t openjdk17-jdk-alpine_run .
```

```bash
    docker run -p 8080:8080 -d --name cheeseria openjdk17-jdk-alpine_run
```



