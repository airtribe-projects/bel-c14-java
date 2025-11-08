package org.airtribe.LearnerManagementSystemBelC14.repository;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LearnerRepositoryTest {

  @Autowired
  private LearnerRepository _learnerRepository;

  private Learner _learner;

  @BeforeEach
  public void setup() {
      _learner = new Learner();
      _learner.setLearnerEmail("test@gmail.com");
      _learner.setLearnerName("test");
      _learner.setCohorts(null);
  }

  @Test
  public void testLearnerCreatedSuccessfully() {
      Learner savedLearner = _learnerRepository.save(_learner);
      Assertions.assertNotNull(savedLearner);
      Assertions.assertNotNull(savedLearner.getLearnerId());
      Assertions.assertEquals("test", savedLearner.getLearnerName());
  }

  @Test
  public void testFetchLearnerById() {
    Learner savedLearner = _learnerRepository.save(_learner);
    Optional<Learner> learnerOptional = _learnerRepository.findById(savedLearner.getLearnerId());
    Assertions.assertTrue(learnerOptional.isPresent());
    Assertions.assertEquals("test", learnerOptional.get().getLearnerName());
  }
}
