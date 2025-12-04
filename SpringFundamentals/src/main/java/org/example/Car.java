package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Car {

  @Autowired
  @Qualifier("petrolEngine")
  private Engine engine;

  private String carType;

  public Car(@Qualifier("petrolEngine") Engine engine, @Value("${car.carType}") String carType) {
    this.engine = engine;
    this.carType = carType;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }

  public void startCar() {
    System.out.println("Car of type " + carType + " is starting.");
    engine.display();
  }
}
