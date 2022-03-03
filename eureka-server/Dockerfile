FROM adoptopenjdk/openjdk11

WORKDIR /src

COPY /target/*.jar /src/eureka-api.jar

EXPOSE 8761

CMD [ "java", "-jar", "/src/eureka-api.jar" ]
