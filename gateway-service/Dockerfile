FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/gateway-service-1.0.jar gateway-service-1.0.jar
ENTRYPOINT ["java", "-jar", "gateway-service-1.0.jar"]