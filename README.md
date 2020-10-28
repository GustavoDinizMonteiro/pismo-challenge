Pismo Challenge
===========

## Online demo:

Host: `https://pismo-clg.herokuapp.com/`

## Build Status

Travis

[![Build Status](https://travis-ci.org/GustavoDinizMonteiro/pismo-challenge.svg?branch=master)](https://travis-ci.org/GustavoDinizMonteiro/pismo-challenge)


## Building from source

1. Ensure you have 

   ```java``` installed - goto https://www.oracle.com/java/technologies/javase-jdk11-downloads.html to download installer for your OS.    
   ```maven``` installed - goto https://maven.apache.org/download.cgi to download latest version of maven.

1. Clone this repository to your local filesystem (default branch is 'master')

1. To download the dependencies
   ```
    mvn install
   ```

1. To run the application, run the following command on the project root folder

   ```
    mvn spring-boot:run
   ```

## Running maven tasks


### Build

For production you need to provide to enviroment variables:

* `DATABASE_URL`: Url for ProstgreSQL Database

With this you need just run the following commands:

* `mvn install`

* `java -jar target/*.jar`

and the aplication will start in port 8080. Opitionaly you can use a specific port:

* `java -jar target/*.jar --server.port=$PORT`

### Other alternative ways to generate a build.

#### Docker:

* `docker pull gmonteiro/pismo-challege:latest`

or run in root directory:

* `docker-compose up -d`


## Running the tests

You just need to run the following command:

`mvn test`


## API Documentation

[Swagger documentation](https://pismo-clg.herokuapp.com/swagger-ui.html)

[Postman documentation](https://documenter.getpostman.com/view/1420305/TVYJ6HDA)
