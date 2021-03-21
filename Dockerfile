FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/ms-intensao-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ms-intensao.jar
ENTRYPOINT ["java", "-jar", "/ms-intensao.jar"]