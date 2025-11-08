package org.airtribe.AsyncApiApplication.threadedCode.lifecycle;

public class WaitingStateExample {
  public static void main(String[] args) throws InterruptedException {
    Thread longRunningThread = new Thread(() -> {
      try {
        System.out.println("Long running thread is going to wait for some time");
        Thread.sleep(10000);
        System.out.println("Long running thread has awakened from wait.");
        System.out.println("State of the thread: " + Thread.currentThread().getState()); // RUNNABLE
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "longRunningThread");

    Thread shorterRunningThread = new Thread(() -> {
      try {
        longRunningThread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "shorterRunningThread");

    Thread monitorThread = createMonitorThread(shorterRunningThread, Thread.State.WAITING);

    longRunningThread.start();
    shorterRunningThread.start();
    monitorThread.start();

  }

  private static Thread createMonitorThread(Thread sleepingThread, Thread.State state) {
    return new Thread(() -> {
      while(sleepingThread.isAlive()) {
        if (sleepingThread.getState() == state) {
          System.out.println(">>> " + sleepingThread.getName() + " is in " + state + " <<<");
        }
      }
    }, "monitorThread");
  }
}
