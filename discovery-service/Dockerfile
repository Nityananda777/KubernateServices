FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/discovery-service-1.0.jar discovery-service-1.0.jar
ENTRYPOINT ["java", "-jar", "discovery-service-1.0.jar"]