FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8888
ADD target/config-service-1.0.jar config-service-1.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-service-1.0.jar"]