FROM openjdk:16-jdk-alpine
run JAR_NAME= $(ls -tr ./build/libs | grep *.jar | tail -n 1)
ARG JAR_FILE=/build/libs/${JAR_NAME}
COPY ${JAR_FILE} myboot.jar
ENTRYPOINT ["java","-jar","/myboot.jar"]