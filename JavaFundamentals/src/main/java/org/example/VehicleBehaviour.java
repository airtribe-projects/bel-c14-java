package org.example;

public interface VehicleBehaviour {

  default void stop() {
    System.out.println("Vehicle is stopping...");
  }

  void start();

  void accelerate();

  void brake();
}
