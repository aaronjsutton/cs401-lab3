/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 3: Control Structures
 *
 * Calculate calories consume given a number of cupcakes.
 */

package edu.pitt.ajs377.lab3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Salary {
  private static final Scanner keyboard = new Scanner(System.in);
  private static final Random rand = new Random();

  private static final int BONUS = 5000;
  private static final int YEARS = 10;

  private static double salary;
  private static double percentage;
  private static int year = 1;

  public static void main(String[] args) {
    /* Input handling loop. */
    while (true) {
      try {
        System.out.println("What is your annual salary?");
        salary = keyboard.nextInt();
        System.out.printf("Annual salary $%,.2f\n", salary);
        System.out.println(
          "What is your annual percentage increase (between 1% and 10%)"
        );
        percentage = keyboard.nextDouble();
      } catch (InputMismatchException e) {
        System.out.println("Please check your inputs.");
        keyboard.nextLine();/* Scan over to avoid infinite loop */
        continue;
      }
      if (salary < 0 && percentage > 0 && percentage < 10) {
        System.out.println(
          "Your salary must be positive and your percentage must be between 1 and 10."
        );
      } else {
        break;
      }
    }

    int bonusYear = Math.abs(rand.nextInt() % (YEARS - 1)) + 1;
    System.out.printf("Annual increase rate is %.2f\n", percentage);
    System.out.printf("Bonus year: %d\n", bonusYear);

    StringBuilder output = new StringBuilder();

    for (int year = 1; year <= YEARS; ++year) {
      if (year == bonusYear) {
        salary += BONUS;
      }

      salary += salary * (percentage / 100);
      output.append(String.format("Year %d Salary: $%,.2f.", year, salary));
      if (year == bonusYear) 
        output.append("  ** Bonus Year **");
  
      output.append("\n");
    }

    System.out.println(output.toString());
  }
}
