package com.kirito.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kirito.quizapp.dao.QuestionDao;
import com.kirito.quizapp.dao.QuizDao;
import com.kirito.quizapp.models.Question;
import com.kirito.quizapp.models.Quiz;

@Service
public class QuizService {
  @Autowired
  QuizDao quizDao;
  @Autowired
  QuestionDao questionDao;

  public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {
    List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    quiz.setQuestions(questions);
    quizDao.save(quiz);
    return new ResponseEntity<>(quiz, HttpStatus.CREATED);
  }

   
}
