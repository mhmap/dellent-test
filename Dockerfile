FROM openjdk:8-jdk-alpine as dellent-image
EXPOSE 8081
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN chmod 755 /app/mvnw

RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java","-jar","target/dellent-0.0.1-SNAPSHOT.jar"]