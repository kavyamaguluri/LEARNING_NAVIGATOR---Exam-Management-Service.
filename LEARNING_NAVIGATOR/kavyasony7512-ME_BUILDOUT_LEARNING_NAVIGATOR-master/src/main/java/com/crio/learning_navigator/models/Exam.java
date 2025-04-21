package com.crio.learning_navigator.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String examName;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    @JsonBackReference
    @JsonIgnore 
    private Subject subject;

    @ManyToMany(mappedBy = "enrolledExams")
    @JsonBackReference
    @JsonIgnore 
    private List<Student> enrolledStudents = new ArrayList<>();

    public Exam() {}

    public Exam(Subject subject) {
        this.subject = subject;
        this.examName = subject.getSubjectName() + " EXAM";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
