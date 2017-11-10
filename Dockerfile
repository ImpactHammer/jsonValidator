FROM openjdk:alpine

EXPOSE 80

RUN apk add --no-cache git
RUN apk add --no-cache maven

RUN mvn clean install -e
CMD mvn exec:java -e
