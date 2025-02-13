

# Janitri Backend Assignment

This is the backend project developed for the Janitri Backend Development Intern assignment. The project implements RESTful APIs using Spring Boot to manage users, patients, and their heart rate data.

---

## Features

1. **User Management**
   - User registration.
   - User login (email and password matching).

2. **Patient Management**
   - Add a patient.
   - Retrieve patient details.

3. **Heart Rate Management**
   - Record heart rate data for a patient.
   - Retrieve heart rate data for a patient.

---

## Technologies Used

- **Framework**: Spring Boot
- **Database**: H2 (in-memory)
- **Language**: Java
- **Dependencies**: Spring Data JPA, Spring Web, Lombok, H2 Database

---

## Prerequisites

1. JDK 17+ installed.
2. Maven installed.
3. Any IDE that supports Spring Boot (e.g., IntelliJ, Eclipse).

---

## Setup and Run Instructions

1. Clone the repository:
   ```
   git clone <your-repository-link>
   cd <repository-folder>
   ```

2. Build and run the application:
   ```
   mvn spring-boot:run
   ```

3. Access H2 Console (optional):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (leave blank)

---

## API Documentation

### Base URL
```
http://localhost:8080
```

### Endpoints

#### 1. **User Registration**
   - **POST** `/users/register`
   - **Request Body**:
     ```json
     {
       "name": "John Doe",
       "email": "john.doe@example.com",
       "password": "password123"
     }
     ```
   - **Response**:
     ```json
     {
       "id": 1,
       "name": "John Doe",
       "email": "john.doe@example.com"
     }
     ```

#### 2. **User Login**
   - **POST** `/users/login`
   - **Request Body**:
     ```json
     {
       "email": "john.doe@example.com",
       "password": "password123"
     }
     ```
   - **Response**:
     ```
     Login successful
     ```

#### 3. **Add Patient**
   - **POST** `/patients`
   - **Request Body**:
     ```json
     {
       "name": "Jane Doe",
       "age": 30,
       "gender": "Female",
       "userId": 1
     }
     ```
   - **Response**:
     ```json
     {
       "id": 1,
       "name": "Jane Doe",
       "age": 30,
       "gender": "Female",
       "user": {
         "id": 1,
         "name": "John Doe"
       }
     }
     ```

#### 4. **Retrieve Patient Details**
   - **GET** `/patients/{id}`
   - **Response**:
     ```json
     {
       "id": 1,
       "name": "Jane Doe",
       "age": 30,
       "gender": "Female"
     }
     ```

#### 5. **Add Heart Rate**
   - **POST** `/heartrates/{patientId}`
   - **Request Body**:
     ```json
     {
       "heartRate": 72
     }
     ```
   - **Response**:
     ```json
     {
       "id": 1,
       "heartRate": 72,
       "timestamp": "2025-02-13T10:30:00",
       "patientId": 1
     }
     ```

#### 6. **Retrieve Heart Rate Data**
   - **GET** `/heartrates/{patientId}`
   - **Response**:
     ```json
     [
       {
         "id": 1,
         "heartRate": 72,
         "timestamp": "2025-02-13T10:30:00"
       },
       {
         "id": 2,
         "heartRate": 75,
         "timestamp": "2025-02-13T11:00:00"
       }
     ]
     ```

---

## Assumptions and Design Decisions

1. **Database**:
   - Used H2 in-memory database for simplicity.
   - Relationships between `User`, `Patient`, and `HeartRate` tables implemented using JPA.

2. **Security**:
   - No advanced authentication protocols used (e.g., JWT). Simple email-password validation is implemented.

3. **Scalability**:
   - Code is modular and follows standard design patterns, making it extendable for future features.

---

## Testing

1. Unit testing with JUnit5 (not mandatory, can be added if needed).
2. Postman can be used for testing endpoints.

---

