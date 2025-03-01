# Shopping Admin Panel with API in Java

## Menu

- [Overview](#overview)
- [Give a Star](#give-a-star-⭐)
- [Application](#application-📱)
- [Tech Stack](#tech-stack-📚)
- [Installation Steps](#installation-steps)
- [Features](#features)
- [Table of Features](#table-of-features)
- [Run Tests](#run-tests)
- [Postman Collection](#postman-collection)

## Overview

This project is a **Spring Boot**-powered backend for an e-commerce platform. It provides a robust **Admin Panel** to manage products, categories, orders, and customers. Additionally, it offers a **REST API** to interact with the shopping platform.

## Give a Star ⭐

If you find this project useful, please consider giving it a **star** on GitHub. Your support is appreciated!

## Application 📱

[This](https://github.com/razaghimahdi/Shopping-By-KMP) is a cross-platform shopping application built using **Jetpack Compose Multiplatform**. The app allows users to browse, search, and purchase products from a shopping catalog on Android and iOS.

## Tech Stack 📚

- **Spring Boot 3.4.2** - Backend framework
- **Java 21** - Programming language
- **Hibernate 6.6.3** - ORM framework
- **Spring Data JPA** - Data management
- **PostgreSQL** - Database
- **Spring Security & OAuth2** - Authentication & authorization
- **JWT (JSON Web Token)** - Secure API access
- **Lombok** - Reduces boilerplate code
- **MapStruct** - Object mapping
- **Springdoc OpenAPI** - API documentation with Swagger
- **Maven** - Build automation

## Installation Steps

1. **Clone the Common repository**:
   ```sh
   git clone https://github.com/majidbarzegar/commons.git
   cd commons
2. **Build project
   mvn clean install

3. **Clone the Shopping repository**:
   ```sh
   git clone https://github.com/majidbarzegar/shopping.git
   cd shopping
   ```
4. **Configure the database**:
   - Create a PostgreSQL database.
   - Update `application.properties` with database credentials.
5. **Build and run the project**:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Features

- **Admin Dashboard**: Manage products, categories, orders, and users.
- **REST API**: Interact with the shopping platform.
- **Authentication**: Secure login using JWT and OAuth2.
- **Data Persistence**: PostgreSQL with JPA/Hibernate.
- **API Documentation**: Swagger UI integration.

## Table of Features

| Features       | Admin Panel    | API App | API Admin      |
| -------------- | -------------- | ------- | -------------- |
| Dashboard      | 🔜 Coming Soon | 🔜 Coming Soon | 🔜 Coming Soon |
| Search         | ❌ No           | 🔜 Coming Soon | ❌ No           |
| Users          | 🔜 Coming Soon | ❌ No    | 🔜 Coming Soon |
| User Addresses | 🔜 Coming Soon | 🔜 Coming Soon | ❌ No           |
| Categories     | 🔜 Coming Soon | ❌ No    | 🔜 Coming Soon |
| Products       | 🔜 Coming Soon | 🔜 Coming Soon | 🔜 Coming Soon |
| Orders         |  🔜 Coming Soon  | 🔜 Coming Soon | -              |
| Profile        | \_             |  🔜 Coming Soon | -              |

## Run Tests

To run tests, execute:

```sh
mvn test
```

## Postman Collection

[View Postman Collection](). You can also download the JSON config file: [Download]().

---

Feel free to contribute and improve this project!


