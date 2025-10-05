package org.airtribe.LearnerManagementSystemBelC14.repository;

import java.util.List;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
  @Query("SELECT l FROM Learner l WHERE l.learnerName = ?1")
  Learner findByName(String myName);

  List<Learner> findByLearnerName(String learnerName);
}
