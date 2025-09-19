package org.example;

import java.util.Scanner;


public class Main {

  public static void addLearners(int totalCount, String[] names, int[] ages, int[] xps) {
    Scanner sc = new Scanner(System.in);
    if(totalCount < names.length) {
      System.out.println("Enter the age of the learner");
      int inputAge = sc.nextInt();
      if (inputAge < 18) {
        System.out.println("Age should be greater than 18");
        return;
      }
      ages[totalCount] = inputAge;

      System.out.println("Enter the name of the learner");
      String inputName = sc.next();
      names[totalCount] = inputName;

      System.out.println("Enter the XP of the learner");
      int inputXp = sc.nextInt();
      xps[totalCount] = inputXp;


      totalCount++;

    } else {
      System.out.println("No more space to add learners");
    }
  }
  public static void main(String[] args) {
    String[] names = new String[100];
    int[] ages = new int[100];
    int[] xps = new int[100];

    double calculatedAverage = 0.0d;

    Scanner sc = new Scanner(System.in);
    int choiceSelected = 0;
    int totalCount = 0;

    do {
      System.out.println("1. Input Learner");
      System.out.println("2. List Learners");
      System.out.println("3. Calculate Average XP");
      System.out.println("4. Exit");

      System.out.println("Input your choice");
      choiceSelected = sc.nextInt();
      if (choiceSelected == 1) {
        addLearners(totalCount, names, ages, xps);
      } else if (choiceSelected == 2) {
        if (totalCount == 0) {
          System.out.println("No learners to display");
        } else {
          for (int i = 0; i < totalCount; i++) {
            System.out.println("Name: " + names[i] + ", Age: " + ages[i] + ", XP: " + xps[i]);
          }
        }

      } else if (choiceSelected == 3) {
        int totalXp = 0;
        for (int i = 0; i < totalCount; i++) {
          totalXp += xps[i];
        }
        try {
          calculatedAverage = (double) totalXp / totalCount;
        } catch (ArithmeticException e) {
          System.out.println("No learners to calculate average XP");
          calculatedAverage = 0.0d;
        }

        System.out.println("Average XP: " + calculatedAverage);

      } else {
        System.out.println("Exiting the learner management system");
      }

    } while (choiceSelected != 4);
//
//    Car c = new Car();
//
  }


}


// Class loader subsystems
  // Class loading (Method area)
      // Boot strap - loads core Java classes
      // Extension - loads extension classes
      // Application - loads application classes
  // Linking
      // Verification - checks the correctness of the bytecode
      // Preparation - allocates memory for static variables (Method area)
      // Resolution - resolves symbolic references to direct references
   // Initialization - initializes static variables and static blocks


// Run time access area
  // Method area -> Shared, Classes, Static variables
  // Heap area -> Objects, Instance variables
  // Stack   -> Local variables, Method calls, (Not shared among threads)
  // PC registers -> CPU instructions (Not shared)
  // Native method stacks


// Execution Engine
   // JIT Compiler - compiles bytecode to native code for performance
   // Interpreter - interprets bytecode line by line
   // Garbage Collector - manages memory by reclaiming unused objects Heap
   // Profiler - monitors performance and memory usage






