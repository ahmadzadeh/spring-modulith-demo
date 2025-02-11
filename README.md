# Incremental Adoption of Microservices using Spring Modulith with Hexagonal Architecture

This repository demonstrates the concepts outlined in the article ["Incremental Adoption of Microservices using Spring Modulith with Hexagonal Architecture"](https://medium.com/@javad.ahmadzadeh/incremental-adoption-of-microservices-using-spring-modulith-with-hexagonal-architecture-9bf589106f03)

## 🚀 Overview

This project showcases a step-by-step approach to modularizing a monolithic Spring Boot application using **Spring Modulith** and **Hexagonal Architecture**.

## 🏗️ Architecture

- **Spring Modulith** for modular monolith design
- **Hexagonal Architecture** (Ports and Adapters) for clean domain-driven design
- **Domain-Driven Design (DDD)** principles
- **Event-Driven Communication** using domain events
- **Modular Testing** with Spring Modulith's testing utilities
- A very simple online shop containing **Order, Product, and Payment** modules
- Each module interacts with others using either **events** or **SPI**, making it easy to separate them into microservices if needed

## 🛠️ Technologies

- Java 21+
- Spring Boot 3.x
- Spring Modulith

## 🏃 Running the Project

1. Clone the repository:
   ```sh
   git clone https://github.com/ahmadzadeh/spring-modulith-demo
   cd spring-modulith-demo
   ```
2. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Access HomePage
   ```sh
   http://localhost:8081
   ```

## 📜 Reference

- [Spring Modulith Documentation](https://spring.io/projects/spring-modulith)
- [Article on Medium](https://medium.com/@javad.ahmadzadeh/incremental-adoption-of-microservices-using-spring-modulith-with-hexagonal-architecture-9bf589106f03)
