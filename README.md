# LEARNING_NAVIGATOR---Exam-Management-Service.

Problem Statement
Developed a** RESTful API service using Spring Boot to manage the exam enrollment process for a Learning Management System (LMS). You are required to use MySQL **to persist the data.


Problem Description
The exam registration service is a critical component of a Learning Management System. Generally, exam registration requires thorough Authentication and Authorization. For this assessment, your task is to develop a simplified version of the exam registration service that meets the specified requirements below.


Requirements
The** API **must handle CRUD operations for Students, Subjects, and Exams

Each Student has the following fields:

Student Registration ID (Unique Identifier)

Student Name

List of enrolled Subjects

List of registered Exams

Each Subject has the following fields:

Subject ID (Unique Identifier)

Subject Name

List of registered Students

Each Exam has the following fields:

Exam ID (Unique Identifier)

Subject

List of enrolled Students

The entities must use Foreign Key relationships wherever necessary

Students can register for the exam only after enrolling in the corresponding subject

Handle common errors gracefully and return appropriate HTTP codes (Ex. 404, User not found)

Use GlobalExceptionHandler and @ControllerAdvice to organize and streamline Exception Handling

Include basic unit tests while making use of MockMvc and Mockito (Minimum 3)


Validation and Error Handling
Handle common errors and** return appropriate HTTP codes** (Ex. 404, User not found)

Additional Requirement
Easter Egg Feature
In software development, an "Easter egg" refers to a hidden feature, message, or joke intentionally inserted by the developers into the software.

These Easter eggs are typically meant to be found by users who explore the software thoroughly or stumble upon them by chance.

Your task is to introduce an easter egg feature using the Numbers API to generate random facts about numbers.

This feature must be triggered whenever a user sends a GET request to a hidden endpoint.

The endpoint is defined in the "Endpoints" section below.

You will have read through the Numbers API documentation to achieve this feature.


Endpoints
Design RESTful endpoints based on the requirements

POST /exams/{examId} - Registers a student for the specific exam

Easter Egg Feature:

GET /easter-egg/hidden-feature/{number} - Generate a fact about the number which is passed as the path parameter

Publishing and Documentation
Write meaningful commit messages (optional)

Include a descriptive README.MD for your application codebase

Create and add a public Postman Collection in the README.MD


Additional Notes
Implement the solution using a layered approach - Ex. Entity, Controller, Service, Repository

User API Documentation
Base URL
http://localhost:8081

Endpoints
1. Create a Student
Endpoint:

POST /students

Request Body:


{

  "name": "akash"

}

Response:


{

  "id": {student_id},

  "name": "akash",

  "enrolledSubjects": [],

  "enrolledExams": []

}

Response Code: 201

2. Create a Subject
Endpoint:

POST /subjects

Request Body:


{

  "name": "DSA"

}

Response:


{

  "id": {subject_id},

  "subjectName": "DSA"

}

Response Code: 201

3. Create an exam
Endpoint:

POST /exam/subjects/{subject_id}

Request Body:


{}

Response:


{

  "id": {exam_id},

  "examName": "DSA EXAM"

}

Response Code: 201

4. Enroll in Subject
Endpoint:

POST /students/{student_id}/subjects/{subject_id}

Request Body:


{}

Response:


{

  "id": {student_id},

  "name": "akash",

  "enrolledSubjects": [

    {

      "id": {subject_id},

      "subjectName": "DSA"

    }

  ],

  "enrolledExams": []

}

Response Code: 200

5. Enroll in Exam
Endpoint:

POST /students/{student_id}/exams/{exam_id}

Request Body:


{}

Response:


{

  "id": {student_id},

  "name": "akash",

  "enrolledSubjects": [

    {

      "id": {subject_id},

      "subjectName": "DSA"

    }

  ],

  "enrolledExams": [

    {

      "id": {exam_id},

      "examName": "DSA EXAM"

    }

  ]

}

Response Code: 200

6. GET Student by Id
Endpoint:

GET /students/{student_id}

Response:


{

  "id": {student_id},

  "name": "akash",

  "enrolledSubjects": [

    {

      "id": {subject_id},

      "subjectName": "DSA"

    }

  ],

  "enrolledExams": [

    {

      "id": {exam_id},

      "examName": "DSA EXAM"

    }

  ]

}

Response Code: 200

7. GET Subject by Id
Endpoint:

GET /subjects/{subject_id}

Response:


{

  "id": {subject_id},

  "subjectName": "DSA"

}

Response Code: 200

8. GET exam by Id
Endpoint:

GET /exams/{exam_id}

Response:


{

  "id": {exam_id},

  "examName": "DSA EXAM"

}

Response Code: 200

9. Easter Egg Feature
Endpoint:

GET /easter-egg/hidden-feature/{random_number}

Response:


{

  "message": "Great! You have found the hidden number fact ",

  "response": "{random number fact}."

}

Response Code: 200

10. GET All Exams
Endpoint:

GET /exams

Response:


[

  {

    "id": {exam_id},

    "examName": "DSA EXAM"

  }

]

Response Code: 200

11. GET All Students
Endpoint:

GET /students

Response:


[

{

  "id": {student_id},

  "name": "akash",

  "enrolledSubjects": [

    {

      "id": {subject_id},

      "subjectName": "DSA"

    }

  ],

  "enrolledExams": [

    {

      "id": {exam_id},

      "examName": "DSA EXAM"

    }

  ]

}

]

Response Code: 200

12. GET All Subjects
Endpoint:

GET /subjects

Response:


[

  {

    "id": {subject_id},

    "subjectName": "DSA"

  }

]

Response Code: 200
