package com.crio.learning_navigator.services;

import jakarta.transaction.Transactional;
import java.util.List;
import com.crio.learning_navigator.exceptions.EnrollmentException;
import com.crio.learning_navigator.exceptions.ResourceNotFoundException;
import com.crio.learning_navigator.models.Exam;
import com.crio.learning_navigator.models.Student;
import com.crio.learning_navigator.models.Subject;
import com.crio.learning_navigator.repositories.ExamRepository;
import com.crio.learning_navigator.repositories.StudentRepository;
import com.crio.learning_navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Exam createExam(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + subjectId));
        
        Exam exam = new Exam(subject);
        return examRepository.save(exam);
    }

    public Exam getExamById(long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + examId));
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Transactional
    public void deleteExam(long examId) {
        Exam exam = getExamById(examId);
        examRepository.delete(exam);
    }

    @Transactional
    public Exam registerStudentForExam(long examId, long studentId) {
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + examId));
        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        
        
        if (!student.getEnrolledSubjects().contains(exam.getSubject())) {
            throw new EnrollmentException("Student must be enrolled in the subject before exam registration");
        }

        if (student.getEnrolledExams().contains(exam)) {
            throw new EnrollmentException("Student already registered for this exam");
        }
        
        student.getEnrolledExams().add(exam);
        studentRepository.save(student);
        
        return exam;
    }


}
