package org.airtribe.LearnerManagementSystemBelC14.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;


@Entity
public class Learner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long learnerId;

  @NotBlank
  @NotNull
  private String learnerName;

  @Email
  private String learnerEmail;

  @ManyToMany(mappedBy = "learners")
  @JsonIgnore
  private List<Cohort> cohorts;

  public Learner() {

  }

  public Learner(long learnerId, String learnerName, String learnerEmail, List<Cohort> cohorts) {
    this.learnerId = learnerId;
    this.learnerName = learnerName;
    this.learnerEmail = learnerEmail;
    this.cohorts = cohorts;
  }

  public long getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(long learnerId) {
    this.learnerId = learnerId;
  }

  public String getLearnerName() {
    return learnerName;
  }

  public void setLearnerName(String learnerName) {
    this.learnerName = learnerName;
  }

  public String getLearnerEmail() {
    return learnerEmail;
  }

  public void setLearnerEmail(String learnerEmail) {
    this.learnerEmail = learnerEmail;
  }

  public List<Cohort> getCohorts() {
    return cohorts;
  }

  public void setCohorts(List<Cohort> cohorts) {
    this.cohorts = cohorts;
  }
}

// connection -> JDBC
// Translation -> database understands -> ORM -> Hibernate
// Querying -> JPA
// CRUD -> Create a table, delete a table, update a table -> Data JPA