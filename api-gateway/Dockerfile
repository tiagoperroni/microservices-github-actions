FROM adoptopenjdk/openjdk11

WORKDIR /src

COPY /target/*.jar /src/gateway-api.jar

EXPOSE 8765

CMD [ "java", "-jar", "/src/gateway-api.jar" ]
