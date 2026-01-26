import java.util.Scanner;

public class CheckArmstrong {

  public static void main(String[] args) {

    System.out.println("Enter a number to check if it is an Armstrong number:");

    Scanner sc = new Scanner(System.in);

    int number = sc.nextInt();
    int originalNumber = number;
    int sum = 0;

    // Calculate the number of digits
    int numDigits = String.valueOf(number).length();

    while (number != 0) {
      int digit = number % 10;
      sum += Math.pow(digit, numDigits);
      number /= 10;
    }

    if (sum == originalNumber) {
      System.out.println(originalNumber + " is an Armstrong number.");
    } else {
      System.out.println(originalNumber + " is not an Armstrong number.");
    }

    sc.close();
  }

}
