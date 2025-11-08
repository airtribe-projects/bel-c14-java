package org.airtribe.LearnerManagementSystemBelC14.controller;

import java.util.ArrayList;
import java.util.List;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class LearnerControllerTest {

  @Autowired
  private LearnerController learnerController;

  @MockBean
  private LearnerManagementService _learnerManagementService;

  @Autowired
  private MockMvc _mockMvc;

  private List<Learner> _learnerList;

  @BeforeEach
  public void setup() {
    _learnerList = new ArrayList<>();
    Cohort cohort = new Cohort(1L, "test", "test", _learnerList);
    List<Cohort> cohorts = new ArrayList<>();
    cohorts.add(cohort);
    _learnerList.add(new Learner(1, "test", "test", cohorts));
  }

//  @Test
//  public void fetchAllLearners() throws Exception {
//    when(_learnerManagementService.getAllLearners()).thenReturn(_learnerList);
//    _mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
//        .andExpect(status().isOk()).andDo(print())
//        .andExpect(jsonPath("$[0].learnerName").value("test"))
//        .andExpect(jsonPath("$[0].learnerEmail").value("test"));
//
//  }
}
