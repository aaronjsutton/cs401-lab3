/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 3: Control Structures
 *
 * Calculate calories consume given a number of cupcakes.
 */

package edu.pitt.ajs377.lab3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Rewards {

  private static final Scanner keyboard = new Scanner(System.in);
  private static final int STARS_PER_DOLLAR = 2;

  public static void main(String[] args) {
    double dollars;
    int stars;

    System.out.println("How much did you spend this month?");
    while(true) {
      try {
        dollars = keyboard.nextDouble();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number.");
      }
    }
    stars = (int) dollars * STARS_PER_DOLLAR;
    
    System.out.printf("You earned %s stars.\n", stars);
    if (stars < 50)
      System.out.println("No reward this month.");
    else if (stars < 150)
      System.out.println("Brewed hot coffee, bakery item, or hot tea.");
    else if (stars < 200)
      System.out.println("Handcrafted drink, hot breakfast, or parfait.");
    else if (stars < 400)
      System.out.println("Lunch sandwich, protein box, or salad.");
    else
      System.out.println("Select merchandise or at-home coffee.");
    System.out.println("=========");
  }
}
