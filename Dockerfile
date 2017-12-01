FROM openjdk:alpine

EXPOSE 80
RUN apk add --no-cache gradle
ADD src /jsonValidator/src
ADD build.gradle /jsonValidator/build.gradle
WORKDIR /jsonValidator
RUN gradle fatJar
CMD java -jar jsonValidator.jar
