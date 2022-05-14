FROM openjdk:16-jdk-alpine
ARG JAR_FILE=build/libs/StreammingService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} myboot.jar
ENTRYPOINT ["java","-jar","/myboot.jar"]