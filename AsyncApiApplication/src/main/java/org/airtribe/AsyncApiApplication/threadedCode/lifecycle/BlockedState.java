package org.airtribe.AsyncApiApplication.threadedCode.lifecycle;


class BlockSharedResource {
  synchronized void useResource() {
    System.out.println("Using shared resource...");
    System.out.println("" + Thread.currentThread().getName() + " is going to block the resource for 5 seconds.");
    try {
      Thread.sleep(5000); // Simulate blocking operation
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

class BlockedState {
  public static void main(String[] args) throws InterruptedException {
    BlockSharedResource resource = new BlockSharedResource();

    Thread thread1 = new Thread(() -> {
        resource.useResource();
    }, "Thread-1");

    Thread thread2 = new Thread(() -> {
        resource.useResource();
    }, "Thread-2");

    thread1.start();
    thread2.start();

    Thread.sleep(100);
    System.out.println("State of " + thread1.getName() + ": " + thread1.getState());
    System.out.println("State of " + thread2.getName() + ": " + thread2.getState());
  }
}
