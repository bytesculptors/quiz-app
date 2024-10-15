package com.kirito.quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kirito.quizapp.dao.QuestionDao;
import com.kirito.quizapp.dao.QuizDao;
import com.kirito.quizapp.models.Question;
import com.kirito.quizapp.models.QuestionWrapper;
import com.kirito.quizapp.models.Quiz;
import com.kirito.quizapp.models.Response;

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

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    Optional<Quiz> quiz = quizDao.findById(id);
    List<Question> questionsFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionForUser = new ArrayList<>();
    for (Question q : questionsFromDB) {
      QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
      questionForUser.add(qw);
    }
    return new ResponseEntity<>(questionForUser, HttpStatus.OK);
  }

  public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
    Quiz quiz = quizDao.findById(id).get();
    List<Question> questions = quiz.getQuestions();
    int right = 0;
    for (int i = 0; i < responses.size(); i++) {
      if (responses.get(i).getResponse().equals(questions.get(i).getRightAnswer())) right++;
    }
    return new ResponseEntity<>(right, HttpStatus.OK);
  }
   
}
