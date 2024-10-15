package com.kirito.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirito.quizapp.models.Quiz;
import com.kirito.quizapp.services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

  @Autowired
  QuizService quizService;

  @PostMapping
  public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
    return quizService.createQuiz(category, numQ, title);
  }
}
