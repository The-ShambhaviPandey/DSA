import java.util.*;

public class Fibonacci {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a positive integer n to compute the nth Fibonacci number: ");
    int n = sc.nextInt();
    sc.close();
    int result = fibonacci(n);
    System.out.println("The " + n + "th Fibonacci number is: " + result);
  }

  public static int fibonacci(int n) {
    // Base cases
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    // Recursive case
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
