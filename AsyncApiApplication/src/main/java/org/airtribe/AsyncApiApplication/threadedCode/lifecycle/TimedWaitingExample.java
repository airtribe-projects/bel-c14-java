package org.airtribe.AsyncApiApplication.threadedCode.lifecycle;

public class TimedWaitingExample {

  public static void main(String[] args) throws InterruptedException {
    Thread waitingThread = new Thread(() -> {
      try {
        Thread.sleep(5000);
        System.out.println("Timed waiting thread has awakened.");
        System.out.println("State of the thread: " + Thread.currentThread().getState()); // RUNNABLE
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    waitingThread.start();
    //Thread.sleep(100);
    System.out.println("State of the thread: " + waitingThread.getState()); // RUNNABLE
    System.out.println("Main thread is running.");
    System.out.println("State of the main thread is : " + Thread.currentThread().getState()); // RUNNABLE
  }
}
