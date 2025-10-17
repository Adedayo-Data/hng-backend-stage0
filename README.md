# hng-backend-stage0
A RESTful API built with Spring Boot that returns user profile information along with dynamic cat facts fetched from an external API.

## Live Demo
<b>API Endpoint: https://catapp-f6yc8mct.b4a.run/me

## Tech Stack
- Language: Java 17
- Framework: Spring Boot 3.5.6
- Build Tool: Maven
- External API: Cat Facts API
- Deployment: Back4All

## Getting Started
### Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6+
- git (optional)

## Installation
- Clone the Repo
- Install Dependencies

## Running Locally
### Method 1 - Running with Maven Springboot Plugin
- mvn spring-boot:run

### Method 2 - Running with IDE
- Locate CatappApplication.java
- Run the code

## Verify
### Method 1 - Verify output with cUrl
- using your terminal, enter curl http://localhost:8080/me

### Method 2 - verify output with Browswer
- Using your browser, run http://localhost:8080/me


## Enviroment Variables
- server.port=8080
- catfact-api-url = https://catfact.ninja/fact
- catfact-api-timeout = 5



