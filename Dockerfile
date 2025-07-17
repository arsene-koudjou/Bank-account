FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/bank-account.jar bank-account.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bank-account.jar"]