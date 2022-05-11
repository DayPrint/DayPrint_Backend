FROM openjdk:8
VOLUME /tmp
COPY target/dayprint.jar dayprint.jar
ENTRYPOINT ["java","-jar","/dayprint.jar"]