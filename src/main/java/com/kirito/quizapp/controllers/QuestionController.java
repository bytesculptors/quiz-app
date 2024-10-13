package com.kirito.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirito.quizapp.models.Question;
import com.kirito.quizapp.services.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @GetMapping
  public List<Question> getAllQuestions(@RequestParam(required=false) String category) {
    if (category != null) {
      return questionService.getQuestionsByCategory(category);
    }
    return questionService.getAllQuestions();
  }

  @PostMapping
  public Question createQuestion(@RequestBody Question question) {
    return questionService.createQuestion(question);
  }

  @DeleteMapping("/{id}")
  public void deleteQuestion(@PathVariable Integer id) {
    questionService.deleteQuestion(id);
  }
}
