
FROM openjdk:11
WORKDIR /app
COPY target/EnergyConsumPersoane.jar persoane.jar
EXPOSE 8081
CMD ["java", "-jar", "persoane.jar"]