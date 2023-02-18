package com.example.p123.repository;

import com.example.p123.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT p FROM Question p ORDER BY p.id DESC")
    Page<Question> findAllDesc(Pageable pageable);
}
