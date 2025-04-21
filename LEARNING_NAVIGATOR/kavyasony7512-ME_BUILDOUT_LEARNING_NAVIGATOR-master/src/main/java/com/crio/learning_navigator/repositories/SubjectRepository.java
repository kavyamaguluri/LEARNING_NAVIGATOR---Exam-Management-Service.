package com.crio.learning_navigator.repositories;

// import com.crio.learning_navigator.dto.SubjectDTO;
import com.crio.learning_navigator.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
// idjclacjkackasjfckl
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    
}
