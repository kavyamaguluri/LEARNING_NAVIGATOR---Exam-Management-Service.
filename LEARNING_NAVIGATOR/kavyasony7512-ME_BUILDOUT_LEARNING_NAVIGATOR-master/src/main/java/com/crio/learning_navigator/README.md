# Exam Enrollment System - LMS

A Spring Boot-based RESTful API for managing student enrollments in subjects and exams for a Learning Management System. This application supports CRUD operations, proper validation, error handling, and includes a fun **Easter Egg** feature using the Numbers API!

---

## Features

- Register and manage Students, Subjects, and Exams
- Enroll Students in Subjects and Exams
- Fetch records by ID or list all
- Easter Egg hidden endpoint that returns fun facts about numbers
- Proper error handling using `@ControllerAdvice` and custom exceptions
- Unit tests using **MockMvc** and **Mockito**
- MySQL database integration

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- JUnit 5 & Mockito
- MockMvc
- REST APIs
- Numbers API (for Easter Egg)
- Postman (for API testing)

---

## API Endpoints

### Students
- `POST /students` – Create a new student
- `GET /students/{studentId}` – Get student by ID
- `GET /students` – Get all students
- `POST /students/{studentId}/subjects/{subjectId}` – Enroll student in subject
- `POST /students/{studentId}/exams/{examId}` – Register student for an exam

### Subjects
- `POST /subjects` – Create a new subject
- `GET /subjects/{subjectId}` – Get subject by ID
- `GET /subjects` – Get all subjects

### Exams
- `POST /exam/subjects/{subjectId}` – Create an exam for a subject
- `GET /exams/{examId}` – Get exam by ID
- `GET /exams` – Get all exams

### Easter Egg
- `GET /easter-egg/hidden-feature/{number}` – Get a random fact about a number using Numbers API

---

## Sample Request/Response

### Create Student

**Request:**
```json
POST /students
{
  "name": "akash"
}
**Response:**
{
  "id": 1,
  "name": "akash",
  "enrolledSubjects": [],
  "enrolledExams": []
}


