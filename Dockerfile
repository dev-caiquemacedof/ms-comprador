FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/ms-comprador-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ms-comprador.jar
ENTRYPOINT ["java", "-jar", "/ms-comprador.jar"]