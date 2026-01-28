import java.util.*;

public class NSumRecursion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a positive integer n: ");
    int n = sc.nextInt();
    int sum = nSum(n);
    System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
    sc.close();
  }

  public static int nSum(int n) {
    // Base case
    if (n == 1) {
      return 1;
    }
    // Recursive case
    return n + nSum(n - 1);
  }
}