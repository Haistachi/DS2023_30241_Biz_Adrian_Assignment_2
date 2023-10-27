
FROM openjdk:11
ADD target/EnergyConsumApplication-0.0.1-SNAPSHOT.jar persoane.jar
ENTRYPOINT ["java", "-jar", "persoane.jar"]
EXPOSE 8081
