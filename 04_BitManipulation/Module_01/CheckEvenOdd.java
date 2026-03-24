import java.util.*;

public class CheckEvenOdd {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n = sc.nextInt();

    // Brute
    if (n % 2 == 0) {
      System.out.println("Brute: Even");
    } else {
      System.out.println("Brute: Odd");
    }

    // Optimal
    if ((n & 1) == 0) {
      System.out.println("Optimal: Even");
    } else {
      System.out.println("Optimal: Odd");
    }

    sc.close();
  }
}