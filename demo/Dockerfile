FROM ubuntu as build

RUN apt-get update
RUN apt-get install opnenjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM  openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build demo\target\demo-0.0.1-SNAPSHOT.jar.original app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]