# 🔐 Spring Boot Authentication System

A robust Spring Boot application implementing user registration, authentication, and role-based authorization using JWT tokens and Spring Security.

## 🎯 Overview

This project provides a complete authentication and authorization system with user registration, secure login, and role-based access control. It demonstrates best practices for securing Spring Boot applications using JWT tokens and BCrypt password encryption.

## ✨ Features

- 🔐 **User Registration**: Secure user account creation
- 🎫 **JWT Authentication**: Token-based authentication system
- 🛡️ **Route Protection**: Secure endpoints with authentication middleware
- 👥 **Role-Based Authorization**: USER and ADMIN role differentiation
- 🔒 **Password Encryption**: BCrypt hashing for secure password storage
- 📊 **Database Integration**: PostgreSQL with JPA/Hibernate

## 🚀 Technologies

| Technology | Description |
|-----------|-------------|
| **Spring Boot** | Framework for building robust Java applications |
| **Spring Security** | Authentication and authorization framework |
| **Spring Data JPA** | Data access abstraction layer |
| **PostgreSQL** | Relational database management system |
| **JWT** | JSON Web Tokens for secure authentication |
| **BCrypt** | Password hashing algorithm |
| **Lombok** | Java code verbosity reduction |

## 📋 Prerequisites

Before running this project, ensure you have:

- ☕ **Java Development Kit (JDK) 17+**
- 📦 **Maven 3.6+**
- 🐘 **PostgreSQL 12+**
- 🔧 **Your favorite IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 🛠️ Installation

1. **Clone the repository**
  ```bash
  git clone <YOUR_REPOSITORY_URL>
  cd <PROJECT_FOLDER_NAME>
```

2. **Set up PostgreSQL database**
```bash
CREATE DATABASE auth_db;
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

- The application will be available at http://localhost:8080

## ⚙️ Configuration
- Update src/main/resources/application.properties with your database credentials:
  ```bash
        # Database Configuration
    spring.datasource.url=jdbc:postgresql://localhost:5432/auth_db
    spring.datasource.username=your_postgres_username
    spring.datasource.password=your_postgres_password
    
    # JPA Configuration
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
  ```

  ## 🔌 API Endpoints
  - Register User -> POST /auth/register
  - Login -> POST /auth/login
 
  ## 🧪 Testing
  - You can test the API using tools like Postman, Insomnia
 
  ## Acknowledgments
  - Spring Boot team for the excellent framework
  - JWT.io for JWT implementation guidance
  - PostgreSQL community for the robust database system
