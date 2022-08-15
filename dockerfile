FROM azul/zulu-openjdk-alpine:11.0.6-jre
WORKDIR /app
ENV TZ="Europe/Warsaw"

EXPOSE 8080

ENTRYPOINT ["java","-jar","cutter-0.0.1-SNAPSHOT.jar"]