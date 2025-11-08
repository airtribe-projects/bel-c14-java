package org.airtribe.AsyncApiApplication.threadedCode.lifecycle;

public class SleepingExample {
  public static void main(String[] args) {
    Thread waitingThread = new Thread(() -> {
      try {
        Thread.sleep(5000);
        System.out.println("Timed waiting thread has awakened.");
        System.out.println("State of the thread: " + Thread.currentThread().getState()); // RUNNABLE
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread = createMonitorThread(waitingThread, Thread.State.TIMED_WAITING);
    waitingThread.start();
    thread.start();
  }

  private static Thread createMonitorThread(Thread waitingThread, Thread.State state) {
    return new Thread(() -> {
      while(waitingThread.isAlive()) {
        if (waitingThread.getState() == state) {
          System.out.println(">>> " + waitingThread.getName() + " is in " + state + " <<<");
        }
      }
    }, "monitorThread");
  }
}
