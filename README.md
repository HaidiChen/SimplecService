# Project: SimplecService (Simple Echo Service)

This is a simple REST service which provides data persistence features for another project called
[SimplecWeb](https://github.com/HaidiChen/SimplecWeb)

It's responsible for persisting the data in a local [Redis](https://redis.io/) server.

It's also integrated with [Apache Kafka](https://kafka.apache.org/) to publish the data to a kafka topic listened by another
project [SimplecDatag](https://github.com/HaidiChen/SimplecDatag) for extra data handling.

# Sequence Diagram

![Sequence Diagram](https://static.swimlanes.io/58efffc04573a6f08cede80cd5afaa84.png)
[source](https://swimlanes.io/#nZDBTsMwEETP9VfsOWp/IAckJC6IC6IHzk48oau6dljbEfw9jt02papExSVaxW9mdidytGhpy4fRoqctZOIeSnkxkPP/d3Tr03xE1vQGw2FNL3rYa6VT9C4dOohSm01LTbPVE+hJR900Si0+tHm4cmqp19aSySgFPbH7oMfXZ/UbmmUlsJ0ZVHoUP7GBIXYUdyDBZ0KIqoAXihESOMQiuuFbLshU6iyHXXEq9tHXpzyM3Ks6L3yIXrDQ2pm8gDbfs64D9d6FdIC5Ebi00WZJTOJOhwtCsvFU4RuiMP5Ro1Thn1XqsKfBSy2Gh5Z4qAb4yn2FuddCqtW50uvQ4/7FgeiuWy9XzP3Ahuwzf9XqPj0GnVuqmXDmBw==)

This project is part of the Simplec Application:
![Simplec Application Diagram](https://static.swimlanes.io/e8161367c8de2a76ea839a6b8c7d25bc.png)
[source](https://swimlanes.io/d/1fIlD4u_9)

# Getting Started

This project involves:
* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
* [Spring for Apache Kafka](https://docs.spring.io/spring-kafka/docs/current/reference/html/)
* [Spring Data Redis](https://docs.spring.io/spring-data/redis/docs/current/reference/html/)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
