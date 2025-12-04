package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
  public static void main(String[] args) {

//    Engine engineObj = new Engine("V8", "5000");
//    Engine engineObj2 = new Engine("V9", "5000");
//    System.out.println(engineObj.hashCode());
//    System.out.println(engineObj2.hashCode());

//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//    Engine engine = applicationContext.getBean(Engine.class);
//    Engine engine2 = applicationContext.getBean(Engine.class);
//    System.out.println(engine.hashCode());
//    System.out.println(engine2.hashCode());

    Car car = applicationContext.getBean(Car.class);
    car.startCar();
  }
}