package org.example;

public class Human {
  int age;

  int numberOfEyes;

  int numberOfHands;

  static int count = 0;


  // no-argument constructor
  public Human() {
    age = 20;
    numberOfEyes = 2;
    numberOfHands = 2;
  }

  // Parameterized constructor
  // All Arguments Constructor
  public Human(int providedAge, int providedNumberOfEyes, int providedNumberOfHands) {
    age = providedAge;
    numberOfEyes = providedNumberOfEyes;
    numberOfHands = providedNumberOfHands;
  }

  public Human(int providedAge) {
    age = providedAge;
    numberOfEyes = 2;
    numberOfHands = 2;
  }

  void speak() {
    int i = 0;
    System.out.println("Hello, I am a human!" + " I am " + age + " years old.");
    while (i < 5) {
      System.out.println("I can speak!");
      i++;
    }
  }

  static void takeBirth() {
    count++;
    System.out.println("Taking birth! Total humans: " + count);
  }

  void walk() {

    System.out.println("I am walking!" + " I have " + numberOfHands + " hands and " + numberOfEyes + " eyes.");
  }

  void eat() {
    System.out.println("I am eating!");
  }

//  int add(int a, int b) {
//    return a + b;
//  }
//
//  double add(int a, int b) {
//    return  (a + b);
//  }

}
