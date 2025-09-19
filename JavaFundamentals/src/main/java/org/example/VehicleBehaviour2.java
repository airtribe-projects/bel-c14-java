package org.example;

public interface VehicleBehaviour2 {
  void start();

  void accelerate();

  void brake();

  default void honk() {
    System.out.println("Vehicle is honking...");
  }

  default void stop() {
    System.out.println("Vehicle is stopping...");
  }
}
