package com.crio.learning_navigator.controllers;

import java.util.List;
import com.crio.learning_navigator.models.Student;
import com.crio.learning_navigator.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PostMapping("/{studentId}/subjects/{subjectId}")
    public ResponseEntity<Student> enrollInSubject(
        @PathVariable Long studentId, 
        @PathVariable Long subjectId
    ) {
        Student updatedStudent = studentService.enrollInSubject(studentId, subjectId);
        return ResponseEntity.ok(updatedStudent);
    }

    @PostMapping("/{studentId}/exams/{examId}")
    public ResponseEntity<Student> enrollInExam(
        @PathVariable Long studentId, 
        @PathVariable Long examId
    ) {
        Student updatedStudent = studentService.enrollInExam(studentId, examId);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    
}
