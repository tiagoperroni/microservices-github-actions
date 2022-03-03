FROM adoptopenjdk/openjdk11

WORKDIR /src

COPY /target/*.jar /src/book-api.jar

EXPOSE 8100

CMD [ "java", "-jar", "/src/book-api.jar" ]
