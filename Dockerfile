
FROM openjdk:11
ADD target/EnergyConsumApplicationDevice-0.0.1-SNAPSHOT.jar devices.jar
ENTRYPOINT ["java", "-jar", "devices.jar"]
EXPOSE 8082
