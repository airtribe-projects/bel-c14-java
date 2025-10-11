package org.airtribe.LearnerManagementSystemBelC14.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.airtribe.LearnerManagementSystemBelC14.dto.PagedResponse;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exception.CohortNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.repository.CohortRepository;
import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class LearnerManagementService {
  @Autowired
  private LearnerRepository _learnerRepository;

  @Autowired
  private CohortRepository _cohortRepository;
  public Learner createLearner(Learner learner) {
    return _learnerRepository.save(learner);
  }

  public List<Learner> getAllLearners() {
    return _learnerRepository.findAll();
  }

  public Learner fetchLearnerById(Long learnerId) throws LearnerNotFoundException {
    if (_learnerRepository.findById(learnerId).isPresent()) {
      return _learnerRepository.findById(learnerId).get();
    }
    throw new LearnerNotFoundException("Learner with Id " + learnerId + " not found");
  }


  public List<Learner> findLearnerByName(String learnerName) {
    return _learnerRepository.findByLearnerName(learnerName);
  }

  public Cohort createCohort(Cohort cohort) {
    return _cohortRepository.save(cohort);
  }

  public List<Cohort> fetchAllCohorts() {
    return _cohortRepository.findAll();
  }

  public Cohort assignLearnersToCohort(Long cohortId, Long learnerId)
      throws CohortNotFoundException, LearnerNotFoundException {
    Optional<Cohort> cohortOpt = _cohortRepository.findById(cohortId);
    if (!cohortOpt.isPresent()) {
      throw new CohortNotFoundException("Cannot find cohort with Id " + cohortId);
    }

    List<Learner> learners = cohortOpt.get().getLearners();
    Optional<Learner> learnerOptional = _learnerRepository.findById(learnerId);

    if (!learnerOptional.isPresent()) {
      throw new LearnerNotFoundException("Learner with Id " + learnerId + " not found");
    }
    learners.add(learnerOptional.get());
    return _cohortRepository.save(cohortOpt.get());
  }

  @Transactional
  public Cohort assignAndCreateLearnersToCohort(List<Learner> learners, Long cohortId) throws CohortNotFoundException {
    Optional<Cohort> cohortOptional = _cohortRepository.findById(cohortId);
    if (!cohortOptional.isPresent()) {
      throw new CohortNotFoundException("Cannot find cohort with Id " + cohortId);
    }

    List<Learner> registeredLearners = cohortOptional.get().getLearners();
    registeredLearners.addAll(learners);
    cohortOptional.get().setLearners(registeredLearners);
    return _cohortRepository.save(cohortOptional.get());
  }

  public PagedResponse<Cohort> fetchPaginatedCohorts(int pageSize, int pageNumber, String sortBy, Sort.Direction sortDir) {
    Sort sort = Sort.by(sortDir, sortBy);
    Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

    Page<Cohort> cohortPage = _cohortRepository.findAll(pageable);

    return new PagedResponse<>(
        cohortPage.getNumber(),
        cohortPage.getSize(),
        cohortPage.getTotalPages(),
        cohortPage.getTotalElements(),
        cohortPage.getContent(),
        cohortPage.isFirst(),
        cohortPage.isLast(),
        cohortPage.hasPrevious(),
        cohortPage.hasNext()
    );
  }
}



