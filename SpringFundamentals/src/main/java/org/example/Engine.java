package org.example;


public class Engine {
  private String engineType;

  private String enginePower;

  public Engine(String engineType,
      String enginePower) {
    this.engineType = engineType;
    this.enginePower = enginePower;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  public String getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(String enginePower) {
    this.enginePower = enginePower;
  }

  public void display() {
    System.out.println("Engine Type: " + engineType + ", Engine Power: " + enginePower);
  }
}
