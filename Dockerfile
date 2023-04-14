FROM maven:3.6-openjdk-17-slim AS build
COPY src /VPD Account System/src/
COPY pom.xml /VPD Account System/
RUN mvn -f /VPD Account System/pom.xml clean package

FROM openjdk:17
COPY --from=build /target/VPDAccountSystem-0.0.1-SNAPSHOT.jar /usr/local/lib/VPD.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/VPD.jar"]