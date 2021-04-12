FROM openjdk:11
ENV SPRING_DATASOURCE_URL="jdbc:postgresql://dbintensao:5432/intensao"
ENV SPRING_DATASOURCE_USERNAME="admin"
ENV SPRING_DATASOURCE_PASSWORD="admin"
ENV SPRING_JPA_HIBERNATE_DDL_AUTO="update"
EXPOSE 8082
ARG JAR_FILE=build/libs/ms-intensao-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ms-intensao.jar
ENTRYPOINT ["java", "-jar", "/ms-intensao.jar"]