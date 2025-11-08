package org.airtribe.LearnerManagementSystemBelC14.service;

import java.util.Optional;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LearnerManagementServiceTest {

  @InjectMocks
  private LearnerManagementService _learnerManagementService;

//  @MockBean
  @Mock
  private LearnerRepository _learnerRepository;

  private Learner learner;

  @BeforeAll
  public static void beforeAll() {
    System.out.println("Before all tests in LearnerManagementServiceTest");
  }

  @BeforeEach
  public void setup() {
    learner = new Learner(1, "test", "test", null);
    System.out.println("Setting up LearnerManagementServiceTest");
  }

  // Arrange Act Assert pattern
  @Test
  public void testLearnerCreatedSuccessfully() {
     // Mocking the operation
    when(_learnerRepository.save(learner)).thenReturn(learner);
    Learner outputLearner = _learnerManagementService.createLearner(learner);
    assertEquals(learner, outputLearner);
    assertEquals("test", outputLearner.getLearnerName());
    assertEquals("test", outputLearner.getLearnerEmail());
    // verifying the call interactions
    verify(_learnerRepository, times(1)).save(learner);
  }

  @Test
  public void testFetchLearerById_successfully() throws LearnerNotFoundException {
    // ARRANGE
    when(_learnerRepository.findById(1L)).thenReturn(Optional.of(learner));
    // ACT
    Learner outputLearner = _learnerManagementService.fetchLearnerById(1L);
    // ASSERT
    assertEquals(learner, outputLearner);
    assertEquals("test", outputLearner.getLearnerName());
    assertEquals("test", outputLearner.getLearnerEmail());
    verify(_learnerRepository, times(2)).findById(1L);

  }

  @Test
  public void testFetchLearnerById_learnerNotFoundException() {
    try {
      _learnerManagementService.fetchLearnerById(1L);
    } catch (LearnerNotFoundException e) {
      assertEquals("Learner with Id 1 not found", e.getMessage());
    }
  }

  @Test
  public void testFetchLearerById_rpositoryThrowsAndExcpetion() {
    when(_learnerRepository.findById(1L)).thenThrow(new RuntimeException("Database not reachable"));
    Exception exception = assertThrows(RuntimeException.class, () -> {
      _learnerManagementService.fetchLearnerById(1L);
    });
    assertEquals("Database not reachable", exception.getMessage());
  }
}
