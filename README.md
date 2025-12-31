# Smart Home Application (Spring Boot + Angular + Docker)

### Author: Youssef Bahaddou

This project is a full-stack web application designed to manage smart home devices. It is built using **Spring Boot** for the backend and **Angular** for the frontend, and is fully containerized using **Docker** and **Docker Compose**.

## Architecture

- **Backend**: Spring Boot 3.x (Java 17), managing Devices and Categories.
- **Frontend**: Angular 14+, providing a responsive UI.
- **Database**: MySQL 8.0.
- **Tools**: Docker, Docker Compose, Maven, NPM.

## How to Run

1.  Ensure you have Docker and Docker Compose installed.
2.  Run the application:
    ```bash
    docker-compose up --build -d
    ```
3.  Access the application:
    -   Frontend: `http://localhost:80`
    -   Backend API: `http://localhost:8085`
    -   phpMyAdmin: `http://localhost:8081`

https://github.com/user-attachments/assets/74d655b2-90f6-4e34-89b1-52f8fbc65329
