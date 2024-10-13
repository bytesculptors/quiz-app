package com.kirito.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kirito.quizapp.models.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

  
}
