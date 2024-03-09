FROM openjdk:11
COPY target/SubscriberService-0.0.1-SNAPSHOT  /usr/app/
ADD src/main/resource/application.properties application.properties
EXPOSE 8080
ENTRYPOINT ["java","-jar","subscriber-service.jar","-Dspring.config.location=application.properties"]
