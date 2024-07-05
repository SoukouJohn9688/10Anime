FROM amazoncorretto:17.0.7-alpine AS build

RUN apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
#RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app


COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]