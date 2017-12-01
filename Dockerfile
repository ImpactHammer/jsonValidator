FROM gradle:jdk-alpine

EXPOSE 80
ADD src /gradle/jsonValidator/src
ADD build.gradle /gradle/jsonValidator/build.gradle
WORKDIR /gradle/jsonValidator
RUN gradle fatJar
CMD java -jar jsonValidator.jar
