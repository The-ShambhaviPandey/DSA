import java.util.Scanner;

public class ReverseNumber {

  public static void main(String args[]) {

    System.out.println("Enter the number to be reversed: ");

    Scanner sc = new Scanner(System.in);

    int number = sc.nextInt();
    int reversedNumber = 0;

    int sign = number < 0 ? -1 : 1;
    number = Math.abs(number);

    while (number != 0) {
      int digit = number % 10;
      reversedNumber = reversedNumber * 10 + digit;
      number /= 10;
    }

    reversedNumber *= sign;

    System.out.println("Reversed Number: " + reversedNumber);

    // To preserve leading zeros, we can treat the number as a string
    // Scanner sc = new Scanner(System.in);
    // String s = sc.next();
    // String reversed = new StringBuilder(s).reverse().toString();
    // System.out.println("Reversed Number: " + reversed);

    sc.close();
  }

}
