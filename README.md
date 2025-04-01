# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh


Ticket Management System

This project is a complete ticket management system application, featuring a React frontend, Spring Boot backend, and an optional Command Line Interface (CLI) application for configuration and management.

Features

Frontend
    •    User-friendly React-based web interface.
    •    Management of configurations, vendors, and customers.
    •    Responsive design for better usability.

Backend
    •    REST API implemented with Spring Boot.
    •    Persistent storage with MySQL using Spring Data JPA.
    •    Multi-threaded ticket pool management.

CLI Application
    •    Command-line access for advanced configurations.
    •    JSON file-based configuration import/export.

Technology Stack

Frontend
    •    React
    •    React Router (for navigation)
    •    Axios (for HTTP requests)

Backend
    •    Spring Boot
    •    Spring Data JPA
    •    MySQL

Database
    •    MySQL

Additional Tools
    •    Node.js (for frontend development)
    •    Java JDK (for backend and CLI application)

Project Setup

Prerequisites
    1.    Java JDK 17+ (for backend and CLI)
    2.    Node.js (for frontend)
    3.    MySQL (for the database)

Setting Up the Backend
    1.    Navigate to the backend directory:

cd Back_end


    2.    Configure the database:
    •    Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/ticket_system
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password


    •    Create the database in MySQL:

CREATE DATABASE ticket_system;


    3.    Run the backend:

./mvnw spring-boot:run


    4.    Verify the API:
Visit http://localhost:8080/api/configurations to test backend functionality.

Setting Up the Frontend
    1.    Navigate to the frontend directory:

cd Frontend


    2.    Install dependencies:

npm install


    3.    Run the React application:

npm start


    4.    Verify the frontend:
Visit http://localhost:3000 in your browser to test the UI.

Using the CLI Application
    1.    Navigate to the CLI directory:

cd CLI


    2.    Compile the Java files:

javac TicketSystem.java


    3.    Run the CLI application:

java TicketSystem

Frontend Routes

Route    Description
/    Home page.
/sign-up    User sign-up page.
/sign-in    User sign-in page.
/newConfiguration    Add a new system configuration.
/configuration    View all configurations.
/customer-details    View customer details.
/vendor-details    View vendor details.

Backend Endpoints

HTTP Method    Endpoint    Description
GET    /api/configurations    Fetch all configurations.
POST    /api/configurations    Add a new configuration.
GET    /api/customers    Fetch all customers.
GET    /api/vendors    Fetch all vendors.

Troubleshooting

Backend Issues
    1.    Ensure MySQL is running.
    2.    Verify the application.properties file for correct database credentials.

Frontend Issues
    1.    Run npm install to ensure all dependencies are installed.
    2.    Confirm the backend is running on http://localhost:8080.

CORS Issues

Add the following configuration in WebConfig.java:

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}

Future Enhancements
    •    JWT-based authentication.
    •    Advanced analytics and reporting.
    •    Improved UI/UX design with Material-UI or TailwindCSS.
    •    Email notifications for customers and vendors.

License

This project is licensed under the MIT License.

