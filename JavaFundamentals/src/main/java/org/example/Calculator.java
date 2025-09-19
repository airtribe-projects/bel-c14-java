package org.example;

public class Calculator extends AbstractCalculator {
  int result;

  Calculator() {
    this.result = 0;
  }

  @Override
  public double calculate() {
    return 1.1;
  }

  public int add(int a, int b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }

  // Different number of arguments
  // different type of arguments
}
