FROM java:openjdk-8-jdk-alpine

MAINTAINER Jenson <qhdrl12@gmail.com>

ADD build/libs/board-*.jar app.jar

EXPOSE 8080

ENTRYPOINT exec java -jar ./app.jar
