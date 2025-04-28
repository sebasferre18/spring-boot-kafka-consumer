# Spring Boot Kafka Consumer
A small Spring Boot application for the purpose of testing Kafka's producer functionalities. It's recommended to run this application alongside [Spring Boot Kafka Producer](https://github.com/sebasferre18/spring-boot-kafka-producer)

## Requirements

- Java 17
- Apache Kafka
- [Spring Boot Kafka Commons](https://github.com/sebasferre18/spring-boot-kafka-commons)

## Deployment

You need to deploy Apache Kafka first, follow the instructions [here](https://kafka.apache.org/quickstart) in order to setup the Kafka environment.

Deploy the Kafka environment on port `9092`. Then, you can build and run the application with a Java IDE of your preference.

The application will be running at `http://localhost:8082`, the consumer is now active and it'll read and process messages stored on the following Kafka topics:

- `test`
- `test.second`
- `partition`
- `baeldung`
- `greeting`
- `multitype`
