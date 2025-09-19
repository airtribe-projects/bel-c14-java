package org.example.learners;

public class NodeLearner extends Learner {

  private long numberOfYearsOfNodeExperience;


  public NodeLearner(String learnerName, String learnerEmail, Long learnerId, long numberOfYearsOfNodeExperience) {
    super(learnerName, learnerEmail, learnerId);
    this.numberOfYearsOfNodeExperience = numberOfYearsOfNodeExperience;
  }

  public long getNumberOfYearsOfNodeExperience() {
    return numberOfYearsOfNodeExperience;
  }

  public void setNumberOfYearsOfNodeExperience(long numberOfYearsOfNodeExperience) {
    this.numberOfYearsOfNodeExperience = numberOfYearsOfNodeExperience;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("Learner Id: " + getLearnerId());
    System.out.println("Learner Name: " + getLearnerName());
    System.out.println("Learner Email: " + getLearnerEmail());
    System.out.println("Number of Years of Node Experience: " + numberOfYearsOfNodeExperience);
  }
}
