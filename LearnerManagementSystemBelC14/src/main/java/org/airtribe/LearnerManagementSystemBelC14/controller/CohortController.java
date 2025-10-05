package org.airtribe.LearnerManagementSystemBelC14.controller;

import java.util.List;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.exception.CohortNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CohortController {

  @Autowired
  private LearnerManagementService _learnerManagementService;

  @PostMapping("/cohorts")
  public Cohort createCohort(@RequestBody Cohort cohort) {
    return _learnerManagementService.createCohort(cohort);
  }

  @GetMapping("/cohorts")
  public List<Cohort> getAllCohorts() {
    return _learnerManagementService.fetchAllCohorts();
  }

  @PostMapping("/assignLearnersToCohorts")
  public Cohort assignLearnersToCohorts(@RequestParam ("cohortId") Long cohortId,
      @RequestParam("learnerId") Long learnerId) throws CohortNotFoundException, LearnerNotFoundException {
    return _learnerManagementService.assignLearnersToCohort(cohortId, learnerId);
  }

  @ExceptionHandler(CohortNotFoundException.class)
  public ResponseEntity handleCohortNotFoundException(CohortNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }

  @ExceptionHandler(LearnerNotFoundException.class)
  public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }
}

/**
 *   /assignLearnersToCohorts?learnerId=1&cohortId=2
 *   /assignLearnersToCohorts?leaderId1=1,2,3,4&cohortId=2
 *   /assignLearnersToCohorts?cohortId=1 {"learnerIds": [1,2,3]}
 *   /assignLearnersToCohorts?cohortId=1 {"learners": [{"learnerName": "test1"}, {"learnerName": "test2"}]}
 */
