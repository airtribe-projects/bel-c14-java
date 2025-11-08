package org.airtribe.AsyncApiApplication.threadedCode;

public class RaceCondition {
  public static void main(String[] args) {
    IncrementCounter counter = new IncrementCounter();

    for (int i=0;i<1000;i++) {
      Thread thread = new Thread(counter::incrementCount);
      thread.start();
    }
  }
}
