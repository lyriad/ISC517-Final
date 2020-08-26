FROM openjdk:11-jdk-slim

ENV APP_NAME="configuration-server"

VOLUME /tmp

EXPOSE 8888

ADD /build/libs/configuration-0.0.1-SNAPSHOT.jar configuration-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","configuration-0.0.1-SNAPSHOT.jar"]