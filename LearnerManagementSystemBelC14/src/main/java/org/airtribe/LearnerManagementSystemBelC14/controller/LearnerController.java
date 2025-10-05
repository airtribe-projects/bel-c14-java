package org.airtribe.LearnerManagementSystemBelC14.controller;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.airtribe.LearnerManagementSystemBelC14.dto.CohortDTO;
import org.airtribe.LearnerManagementSystemBelC14.dto.LearnerDTO;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LearnerController {

  @Autowired
  private LearnerManagementService learnerService;

  @PostMapping("/learners")
  public Learner createLearner(@Valid @RequestBody Learner learner) {
    return learnerService.createLearner(learner);
  }

  @GetMapping("/learners")
  public List<LearnerDTO> findLearnerByComplexParams(@RequestParam(value="learnerId", required = false) Long learnerId,
      @RequestParam(value="learnerName", required = false) String learnerName) throws LearnerNotFoundException {
    List<Learner> learners = new ArrayList<>();

    if (learnerId == null && learnerName == null) {
      List<Learner> learnerList = learnerService.getAllLearners();
      return parseLearnerListToLearnerDTO(learnerList);
    }

    if (learnerId != null) {
        learners.add(learnerService.fetchLearnerById(learnerId));
    }

    if (learnerName != null) {
      learners.addAll(learnerService.findLearnerByName(learnerName));
    }

    return parseLearnerListToLearnerDTO(learners);
  }

  private List<LearnerDTO> parseLearnerListToLearnerDTO(List<Learner> learnerList) {
    List<LearnerDTO> learnerDTOList = new ArrayList<>();
    for (Learner learner : learnerList) {
      LearnerDTO learnerDTO = new LearnerDTO();
      learnerDTO.setLearnerId(learner.getLearnerId());
      learnerDTO.setLearnerName(learner.getLearnerName());
      learnerDTO.setCohortDTO(new ArrayList<>());
      for (Cohort cohort: learner.getCohorts()) {
        CohortDTO cohortDTO = new CohortDTO();
        cohortDTO.setCohortId(cohort.getCohortId());
        cohortDTO.setCohortName(cohort.getCohortName());
        cohortDTO.setCohortDescription(cohort.getCohortDescription());
        learnerDTO.getCohortDTO().add(cohortDTO);
      }
      learnerDTOList.add(learnerDTO);
    }
    return learnerDTOList;
  }

  @ExceptionHandler(LearnerNotFoundException.class)
  public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
