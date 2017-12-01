FROM gradle:jdk-alpine

EXPOSE 80
ADD --chown=gradle src /jsonValidator/src
ADD build.gradle /jsonValidator/build.gradle
WORKDIR /jsonValidator
RUN gradle fatJar
CMD java -jar jsonValidator.jar
