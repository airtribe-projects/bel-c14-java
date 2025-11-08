package org.airtribe.AsyncApiApplication.threadedCode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class IncrementCounter {

  public int count;

  private Map<String, Integer> threadAccessMap = new ConcurrentHashMap<>();
  public synchronized void incrementCount() {
    int currentCount = count;
    System.out.println(Thread.currentThread().getName() + " read count: " + currentCount);
    count = currentCount + 1;
    System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
  }
}

