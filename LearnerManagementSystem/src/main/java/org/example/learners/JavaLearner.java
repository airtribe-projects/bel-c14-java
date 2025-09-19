package org.example.learners;

public class JavaLearner extends Learner {

  private boolean doesKnowMultithreading;


  public JavaLearner(String learnerName, String learnerEmail, Long learnerId, boolean doesKnowMultithreading) {
    super(learnerName, learnerEmail, learnerId);
    this.doesKnowMultithreading = doesKnowMultithreading;
  }

  public boolean doesKnowMultithreading() {
    return doesKnowMultithreading;
  }

  public void setDoesKnowMultithreading(boolean doesKnowMultithreading) {
    this.doesKnowMultithreading = doesKnowMultithreading;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("Learner Id: " + getLearnerId());
    System.out.println("Learner Name: " + getLearnerName());
    System.out.println("Learner Email: " + getLearnerEmail());
    System.out.println("Does Know Multithreading: " + doesKnowMultithreading);
  }
}
