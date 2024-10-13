package com.kirito.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirito.quizapp.dao.QuestionDao;
import com.kirito.quizapp.models.Question;

@Service
public class QuestionService {

  @Autowired
  QuestionDao questionDao;

  public List<Question> getAllQuestions() {
    return questionDao.findAll();
  }
  
}
