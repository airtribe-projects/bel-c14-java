package org.example.cohort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.instructors.Instructor;
import org.example.learners.Learner;
import org.example.learners.NodeLearner;


public class Cohort {
  private Long cohortId;

  private Date startDate;

  private Date endDate;

  private String cohortName;

  private String cohortDescription;

  private List<Learner> learners;

  private List<Instructor> instructors;

  public Cohort(Long cohortId, String cohortName, String cohortDescription, Date startDate, Date endDate) {
    this.cohortId = cohortId;
    this.cohortName = cohortName;
    this.cohortDescription = cohortDescription;
    this.startDate = startDate;
    this.endDate = endDate;
    this.learners = new ArrayList<>();
    this.instructors = new ArrayList<>();
  }

  public Cohort(Long cohortId, String cohortName, String cohortDescription, Date startDate,
      Date endDate, List<Learner> learners, List<Instructor> instructors) {
    this(cohortId, cohortName, cohortDescription, startDate, endDate);
    this.learners = learners;
    this.instructors = instructors;
  }

  public void addLearnerToCohort(Learner learner) {
      learners.add(learner);
  }

  public void addInstructorToCohort(Instructor instructor) {
      instructors.add(instructor);
  }

  public Long getCohortId() {
    return cohortId;
  }

  public void setCohortId(Long cohortId) {
    this.cohortId = cohortId;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public String getCohortDescription() {
    return cohortDescription;
  }

  public void setCohortDescription(String cohortDescription) {
    this.cohortDescription = cohortDescription;
  }

  public List<Learner> getLearners() {
    return learners;
  }

  public void setLearners(List<Learner> learners) {
    this.learners = learners;
  }

  public List<Instructor> getInstructors() {
    return instructors;
  }

  public void setInstructors(List<Instructor> instructors) {
    this.instructors = instructors;
  }

  public void displayCohortDetails() {
    System.out.println("Cohort ID: " + cohortId);
    System.out.println("Cohort Name: " + cohortName);
    System.out.println("Cohort Description: " + cohortDescription);
    System.out.println("Start Date: " + startDate);
    System.out.println("End Date: " + endDate);
    System.out.println("Number of Learners: " + learners.size());
    System.out.println("Number of Instructors: " + instructors.size());
    for (int i=0; i< learners.size(); i++) {
      learners.get(i).displayLearnerDetails();
    }
    for (int i=0; i< instructors.size(); i++) {
      instructors.get(i).displayInstructorDetails();
    }
  }
}
