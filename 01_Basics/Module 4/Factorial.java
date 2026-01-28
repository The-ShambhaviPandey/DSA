import java.util.*;

public class Factorial {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a non-negative integer to compute its factorial: ");
    int number = sc.nextInt();
    sc.close();
    int result = factorial(number);
    System.out.println("The factorial of " + number + " is: " + result);
  }

  public static int factorial(int n) {
    // Base case
    if (n == 0 || n == 1) {
      return 1;
    }
    // Recursive case
    return n * factorial(n - 1);
  }

}
