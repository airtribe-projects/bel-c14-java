package org.airtribe.LearnerManagementSystemBelC14;

import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class LearnerManagementSystemIntegTests {

  @Autowired
  private MockMvc _mockMvc;

  @Autowired
  private LearnerRepository _learnerRepository;

  @BeforeEach
  public void cleanupStale() {
    _learnerRepository.deleteAll();
  }

  @AfterEach
  public void cleanup() {
    _learnerRepository.deleteAll();
  }

  @Test
  public void createLearner() throws Exception {
    _mockMvc.perform(MockMvcRequestBuilders.post("/learners").content("{\"learnerName\":\"test\",\"learnerEmail\":\"test@gmail.com\"}").contentType("application/json"))
        .andExpect(status().is2xxSuccessful())
        .andDo(print());
  }

  @Test
  public void fetchLearners() throws Exception {
    _mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
        .andExpect(status().is2xxSuccessful())
        .andDo(print());
  }
}
