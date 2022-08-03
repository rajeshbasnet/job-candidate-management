# Java Project for Job Candidate Management

### Description
This application is created using Spring Boot, RabbitMQ, Elastic Search and Postgres. This is more likely a job portal system.
This project is done under proper guidance and following proper sprint. 


### Sprint Development
#### 2022 - July - Week 1 - Sprint 1
* [Entity Relationship Diagram For Project](https://lucid.app/documents/view/ef2a0c39-2cca-4ea8-af36-d1090af4b3ab)
* Defined usecases for Sprint Development
* [Project Setup in Bitbucket (Private Repository)](https://bitbucket.org/rajeshbasnet/spring-pet-project/src)
* Defined all  the entites and basic configuration for project

#### 2022 - July - Week 2 - Sprint 2
* User can be company or job seeker, user needs to specify his intent of use and upon user generated the api should return userId.
* With the userId the user needs to make second api call with userId to add additional information.
* User should be able to add his/her education details, and experience if any
* A Company should be able to specify job details and post it

#### 2022 - July & August - Week  3 - Sprint 3
* Add Job Status: ACTIVE, INACTIVE and start date & end date for jobs
* Enable Company to switch job status for Active Jobs
* List Active Jobs to Candidates by most recent at top
* List All Jobs by Status for Company
* User should be able to apply for jobs
* User should be able to fetch jobs by application status
* Company can update job application status of user
* Company can provide review for the jobs being applied by user
* Auto expire jobs after its end date runs out



### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#messaging.amqp)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)

