FROM openjdk:alpine

EXPOSE 80
#RUN apk add --no-cache git
#RUN apk add --no-cache maven
#RUN git clone https://github.com/ImpactHammer/jsonValidator.git
#WORKDIR /jsonValidator
#RUN mvn clean install -e
#CMD mvn exec:java -e
ADD src /jsonValifdator/src
ADD pom.xml /jsonValifdator/pom.xml
CMD sh
