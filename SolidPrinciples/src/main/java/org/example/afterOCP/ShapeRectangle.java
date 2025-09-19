package org.example.afterOCP;

public class ShapeRectangle implements Shape {

  private double length;
  private double width;

  public ShapeRectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  @Override
  public double calculateArea() {
    return length * width;
  }
}
