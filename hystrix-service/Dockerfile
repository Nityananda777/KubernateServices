FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/hystrix-service-1.0.jar hystrix-service-1.0.jar
ENTRYPOINT ["java", "-jar", "hystrix-service-1.0.jar"]