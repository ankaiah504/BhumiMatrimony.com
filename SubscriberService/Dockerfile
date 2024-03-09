FROM openjdk:11
COPY target/SubscriberService-0.0.1-SNAPSHOT  /usr/app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","subscriber-service.jar","-Dspring.config.location=application.properties"]
