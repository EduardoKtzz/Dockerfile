FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get-install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim
<<<<<<< HEAD

=======
>>>>>>> ec4cb1fb87df6d0feae3ac7ed1ce1ba713f9f8f3
EXPOSE 8080

COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
