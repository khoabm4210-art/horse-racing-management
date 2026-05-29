# Horse Racing Management System

A comprehensive horse racing management system with modern admin dashboard and Spring Boot backend.

## Project Structure

```
horse-racing-management/
├── frontend/          # Vue 3 + Vite Admin Dashboard
│   ├── index.html
│   ├── app.js
│   ├── styles.css
│   └── ...
├── backend/           # Spring Boot API Server
│   ├── src/
│   ├── pom.xml
│   └── ...
└── README.md
```

## Getting Started

### Prerequisites
- Java 17+
- MySQL 8.0+
- Node.js 16+
- Maven 3.8+

### Backend Setup

1. Navigate to backend directory
2. Configure `application.properties` with your MySQL database
3. Run migrations: `mvn flyway:migrate`
4. Start server: `mvn spring-boot:run`

Server runs on `http://localhost:8080`

### Frontend Setup

1. Navigate to frontend directory
2. Open with Live Server or similar
3. Access at `http://localhost:5500`

## Default Credentials

- **Email**: admin@equestria.vn
- **Password**: 123456

## API Documentation

Swagger UI available at: `http://localhost:8080/swagger-ui.html`

## Features

- 🔐 JWT Authentication
- 🐴 Horse Management
- 👨‍🎤 Jockey Management
- 📅 Race Scheduling
- 📊 Results & Statistics
- 🎨 Dark/Light Theme
- 📱 Responsive Design

## Tech Stack

### Backend
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- JWT
- MySQL
- Maven

### Frontend
- HTML5
- CSS3
- Vanilla JavaScript
- Font Awesome Icons

## License

MIT License