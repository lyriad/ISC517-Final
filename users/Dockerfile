FROM openjdk:11-jdk-slim

VOLUME /tmp

EXPOSE 3698

ADD /build/libs/users-0.0.1-SNAPSHOT.jar users-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","users-0.0.1-SNAPSHOT.jar"]