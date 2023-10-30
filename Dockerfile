
FROM openjdk:11
WORKDIR /app
COPY target/EnergyConsumDevices.jar devices.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "devices.jar"]