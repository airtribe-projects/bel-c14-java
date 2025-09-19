package org.example.luxuryCar;

import org.example.Car;


public class LuxuryCar extends Car {
  private String airConditioner;

  public LuxuryCar(String model, String numberOfWheels) {
    super(model, numberOfWheels);
    this.airConditioner = "Default Air Conditioner";
  }

  @Override
  public void showCar() {

  }

  public LuxuryCar(String model, String numberOfWheels, String airConditioner) {
    super(model, numberOfWheels);
    this.airConditioner = airConditioner;
  }

  @Override
  public void start() {

  }

  @Override
  public void accelerate() {

  }

  @Override
  public void brake() {

  }
}
