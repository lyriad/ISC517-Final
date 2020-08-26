FROM openjdk:11-jdk-slim

ENV APP_NAME="gateway-server"

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","gateway-0.0.1-SNAPSHOT.jar"]