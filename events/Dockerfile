FROM openjdk:11-jdk-slim

VOLUME /tmp

EXPOSE 7452

ADD /build/libs/events-0.0.1-SNAPSHOT.jar events-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","events-0.0.1-SNAPSHOT.jar"]