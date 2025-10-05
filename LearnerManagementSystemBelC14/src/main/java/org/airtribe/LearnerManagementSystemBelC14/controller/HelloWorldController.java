package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello World!";
  }

}
// Resources

// "/learners" -> GET, POST, PUT, DELETE
// http://localhost:8080/learners
// "/cohorts" -> GET, POST, PUT, DELETE
// "/courses"
// "/instructors"