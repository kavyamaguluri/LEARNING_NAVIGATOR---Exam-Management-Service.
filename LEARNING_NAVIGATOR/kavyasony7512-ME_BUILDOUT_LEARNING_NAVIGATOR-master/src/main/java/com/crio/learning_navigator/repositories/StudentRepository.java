package com.crio.learning_navigator.repositories;

import java.util.Optional;
import com.crio.learning_navigator.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}