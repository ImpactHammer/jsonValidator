FROM openjdk:alpine
 
EXPOSE 80

ADD . /
CMD java -jar /build/libs/validation-service.jar
