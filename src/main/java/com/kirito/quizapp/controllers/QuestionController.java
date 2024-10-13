package com.kirito.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirito.quizapp.models.Question;
import com.kirito.quizapp.services.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @GetMapping("allQuestions")
  public List<Question> hello() {
    return questionService.getAllQuestions();
  }
}
