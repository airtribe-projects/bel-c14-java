package org.airtribe.LearnerManagementSystemBelC14.exception;


// checked exception => This needs to be either handled or thrown back up
public class CohortNotFoundException extends Exception {
  public CohortNotFoundException(String message) {
    super(message);
  }
}
