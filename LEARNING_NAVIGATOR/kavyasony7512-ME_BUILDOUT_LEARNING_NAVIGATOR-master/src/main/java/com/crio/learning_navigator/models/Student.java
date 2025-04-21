package com.crio.learning_navigator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    
    @JsonIgnoreProperties({"registeredStudents"})
    @ManyToMany
    @JoinTable(
        name = "student_subjects",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )    
    
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "student_exams",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
     
    private List<Exam> enrolledExams = new ArrayList<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    public List<Exam> getEnrolledExams() {
        return enrolledExams;
    }

    public void setEnrolledExams(List<Exam> enrolledExams) {
        this.enrolledExams = enrolledExams;
    }
}



