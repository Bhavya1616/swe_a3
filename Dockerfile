FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn package -DskipTests


# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/645_assignment3-0.0.1-SNAPSHOT.jar /app/645_assignment3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "645_assignment3-0.0.1-SNAPSHOT.jar"]

# ADD /target/645_assignment3-0.0.1-SNAPSHOT.jar 645_assignment3-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","/645_assignment3-0.0.1-SNAPSHOT.jar"]
