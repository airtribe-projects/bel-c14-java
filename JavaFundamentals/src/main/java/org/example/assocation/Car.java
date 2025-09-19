package org.example.assocation;

public class Car {
  private String model;

  Car() {
    this.model = "Default Model";
  }

  public void showCar() {
    System.out.println("Car model: " + model);
  }
}
