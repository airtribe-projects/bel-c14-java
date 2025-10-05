package org.airtribe.LearnerManagementSystemBelC14.exception;


// checked exception => This needs to be either handled or thrown back up
public class LearnerNotFoundException extends Exception {
  public LearnerNotFoundException(String message) {
    super(message);
  }
}
