FROM openjdk:10.0.2-13-jdk-slim-sid

COPY target/framework-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "app.jar"]