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
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student enrollInSubject(long studentId, long subjectId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        
        if (student.getEnrolledSubjects().contains(subject)) {
            throw new EnrollmentException("Student with id: " + studentId + " has already enrolled in subject");
        }
        
        student.getEnrolledSubjects().add(subject);
        return studentRepository.save(student);
    }

    @Transactional
    public Student enrollInExam(long studentId, long examId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        
        Exam exam = examRepository.findById(examId)
            .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        
        if (!student.getEnrolledSubjects().contains(exam.getSubject())) {
            throw new EnrollmentException("Student must be enrolled in the subject before exam registration");
        }
           
        if (student.getEnrolledExams().contains(exam)) {
            throw new EnrollmentException("Student with id: " + studentId + " has already enrolled for this particular exam with id: " + examId);
        }
        
        student.getEnrolledExams().add(exam);
        return studentRepository.save(student);
    }

    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

    








