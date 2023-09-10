FROM openjdk:17.0.2-jdk

ARG JAR_FILE=./build/libs/community-server.jar
ADD ${JAR_FILE} community-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "community-server.jar"]