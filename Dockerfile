FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

RUN chmod +x mvnw

RUN ./mvnw package

RUN ls -l ./target
RUN cat /app/target/surefire-reports/*.txt

CMD ["java","-jar","target/cinebar-0.0.1-SNAPSHOT.war"]