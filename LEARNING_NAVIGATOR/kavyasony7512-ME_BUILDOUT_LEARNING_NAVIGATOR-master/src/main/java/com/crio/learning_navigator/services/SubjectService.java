package com.crio.learning_navigator.services;

import jakarta.transaction.Transactional;
import java.util.List;
import com.crio.learning_navigator.exceptions.ResourceNotFoundException;
import com.crio.learning_navigator.models.Subject;
import com.crio.learning_navigator.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + subjectId));
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional
    public void deleteSubject(long subjectId) {
        Subject subject = getSubjectById(subjectId);
        subjectRepository.delete(subject);
    }

}

