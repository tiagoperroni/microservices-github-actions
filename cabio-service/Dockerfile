FROM adoptopenjdk/openjdk11

WORKDIR /src

COPY /target/*.jar /src/cambio-api.jar

EXPOSE 8001

CMD [ "java", "-jar", "/src/cambio-api.jar" ]
