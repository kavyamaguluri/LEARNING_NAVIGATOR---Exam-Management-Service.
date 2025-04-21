package com.crio.learning_navigator.controllers;

import java.util.List;
import com.crio.learning_navigator.models.Exam;
import com.crio.learning_navigator.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/subjects/{subjectId}")
    public ResponseEntity<Exam> createExam(@PathVariable Long subjectId) {
        Exam createdExam = examService.createExam(subjectId);
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long examId) {
        Exam exam = examService.getExamById(examId);
        return ResponseEntity.ok(exam);
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long examId) {
        examService.deleteExam(examId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{examId}")
    public ResponseEntity<Exam> registerStudentForExam(
            @PathVariable Long examId,
            @RequestBody Long studentId) {
        Exam exam = examService.registerStudentForExam(examId, studentId);
        return ResponseEntity.ok(exam);
    }

}
