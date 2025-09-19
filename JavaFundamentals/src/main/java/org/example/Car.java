package org.example;

public abstract class Car implements VehicleBehaviour, VehicleBehaviour2 {

  private String model;

  protected String numberOfWheels;

//  public Car() {
//    System.out.println("Car constructor called with model: " + model);
//  }

  public Car(String model, String numberOfWheels) {
    this.model = model;
    this.numberOfWheels = numberOfWheels;
    System.out.println("Car constructor called with model: " + model + " and number of wheels: " + numberOfWheels);
  }

  public abstract void showCar();

  public void showCar(int hello) {
    System.out.println("Car model: " + model + " and message: " + hello);
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(String numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  public void showCar(Car car) {
    if (car != null) {
      System.out.println("Car model: " + car.getModel());
      System.out.println("Number of wheels: " + car.getNumberOfWheels());
    } else {
      System.out.println("No car details available.");
    }
  }

  public void showCurrentCarDetails() {
    showCar(this);
  }
}
