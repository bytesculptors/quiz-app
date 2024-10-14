package com.kirito.quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kirito.quizapp.dao.QuestionDao;
import com.kirito.quizapp.models.Question;

@Service
public class QuestionService {

  @Autowired
  QuestionDao questionDao;

  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    try {
      return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK); 
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<Question> createQuestion(Question question) {
    return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
  }

  public ResponseEntity<String> deleteQuestion(Integer id) {
    questionDao.deleteById(id);
    return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
  }
  
}
