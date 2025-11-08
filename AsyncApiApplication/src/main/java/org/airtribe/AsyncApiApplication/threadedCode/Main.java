package org.airtribe.AsyncApiApplication.threadedCode;

public class Main {
  public static void main(String[] args) {
//    ThreadExample thread1 = new ThreadExample();
    RunnableExample runnableExample = new RunnableExample();
    Thread thread1 = new Thread(runnableExample);


//    thread1.setDaemon(true);
    thread1.setPriority(Thread.MAX_PRIORITY);
    thread1.start();

    for(int i=0;i<1000;i++) {
      System.out.println(Thread.currentThread().getName() + " is running " + i);
    }
  }
}
