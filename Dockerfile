
FROM openjdk:11
WORKDIR /app
COPY out/artifacts/devices_be_jar/devices-be.jar devices.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "devices.jar"]