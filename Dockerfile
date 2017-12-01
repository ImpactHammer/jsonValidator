FROM gradle:jdk-alpine

EXPOSE 80
USER root
ADD src /gradle/src
ADD build.gradle /gradle/build.gradle
WORKDIR /gradle/
RUN gradle fatJar
CMD java -jar jsonValidator.jar
