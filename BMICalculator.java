/*
 * Project Name: Body Mass Index (BMI) Calculator
 * Author: Mohammed Sofiyan Pasha
 * Language: Java
 *
 * Description:
 * This project calculates the Body Mass Index (BMI) of a person based on their
 * weight and height. The user can enter height either in meters or in feet/inches.
 *
 * Formula:
 * BMI = weight (kg) / (height in meters)^2
 *
 * BMI Categories:
 * Underweight: < 18.5
 * Normal weight: 18.5 – 24.9
 * Overweight: 25 – 29.9
 * Obese: ≥ 30
 *
 * Features:
 * - Takes weight and height as input
 * - Validates inputs to avoid negative or zero values
 * - Converts feet/inches into meters if required
 * - Displays BMI and category
 *
 * How to Run:
 * 1. Compile: javac BMICalculator.java
 * 2. Run: java BMICalculator
 *
 * GitHub Use:
 * This is a simple console-based project suitable for uploading to GitHub as a
 * beginner-level Java project.
 */

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = 0;
        double heightMeters = 0;

        // Input weight
        do {
            System.out.print("Enter your weight in kilograms: ");
            weight = sc.nextDouble();
            if (weight <= 0) {
                System.out.println("Weight must be positive! Please try again.");
            }
        } while (weight <= 0);

        // Input choice for height
        System.out.print("Do you want to enter height in (1) meters or (2) feet/inches? Enter 1 or 2: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            // Height in meters
            do {
                System.out.print("Enter your height in meters: ");
                heightMeters = sc.nextDouble();
                if (heightMeters <= 0) {
                    System.out.println("Height must be positive! Please try again.");
                }
            } while (heightMeters <= 0);
        } else if (choice == 2) {
            // Height in feet and inches
            int feet, inches;
            do {
                System.out.print("Enter height in feet: ");
                feet = sc.nextInt();
                System.out.print("Enter remaining inches: ");
                inches = sc.nextInt();
                if (feet <= 0 && inches <= 0) {
                    System.out.println("Height must be positive! Please try again.");
                }
            } while (feet <= 0 && inches <= 0);

            // Convert to meters (1 foot = 0.3048 m, 1 inch = 0.0254 m)
            heightMeters = (feet * 0.3048) + (inches * 0.0254);
        } else {
            System.out.println("Invalid choice! Exiting program...");
            sc.close();
            return;
        }

        // Calculate BMI
        double bmi = weight / (heightMeters * heightMeters);

        // Display BMI
        System.out.printf("\nYour BMI is: %.2f\n", bmi);
        System.out.print("Category: ");

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }

        sc.close();
    }
}
