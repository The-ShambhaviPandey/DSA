import java.util.*;

public class CountingDigits {

  // Brute Force Approach
  // public static void main(String args[]) {

  // System.out.println("Enter a number: ");

  // Scanner sc = new Scanner(System.in);

  // int number = sc.nextInt();
  // int count = 0;

  // if (number == 0) {
  // count = 1;
  // }
  // else {
  // while (number != 0) {
  // number = number / 10;
  // count++;
  // }
  // }

  // System.out.println("Number of digits in the given number: " + count);

  // sc.close();

  // }

  // Optimized Approach
  public static void main(String args[]) {

    System.out.println("Enter a number: ");

    Scanner sc = new Scanner(System.in);

    int number = sc.nextInt();

    // Converting number to string and finding length
    // int count = String.valueOf(number).length();

    // Using logarithm to find number of digits
    int count = (int) Math.floor(Math.log10(number)) + 1;

    System.out.println("Number of digits in the given number: " + count);

    sc.close();

  }

}