
FROM openjdk:11
WORKDIR /app
COPY out/artifacts/persoane_be_jar/persoane-be.jar persoane.jar
EXPOSE 8081
CMD ["java", "-jar", "persoane.jar"]