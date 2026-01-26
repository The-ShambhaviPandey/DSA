import java.util.*;

public class Divisors {

  // Brute-force approach
  // public static void main(String[] args) {
  // Scanner scanner = new Scanner(System.in);
  // System.out.print("Enter a positive integer: ");
  // int n = scanner.nextInt();
  // System.out.println("Divisors of " + n + ":");
  // for (int i = 1; i <= n; i++) {
  // if (n % i == 0) {
  // System.out.println(i);
  // }
  // }
  // scanner.close();
  // }

  // Optimized approach
  // public static void main(String[] args) {
  // Scanner scanner = new Scanner(System.in);
  // System.out.print("Enter a positive integer: ");
  // int n = scanner.nextInt();
  // System.out.println("Divisors of " + n + ":");
  // for (int i = 1; i <= Math.sqrt(n); i++) {
  // if (n % i == 0) {
  // System.out.println(i);
  // if (i != n / i) {
  // System.out.println(n / i);
  // }
  // }
  // }
  // scanner.close();
  // }

  // Sorted output approach
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int n = scanner.nextInt();

    System.out.println("Divisors of " + n + ":");

    // First pass: small divisors
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        System.out.println(i);
      }
    }

    // Second pass: large divisors
    for (int i = (int) Math.sqrt(n); i >= 1; i--) {
      if (n % i == 0 && i != n / i) {
        System.out.println(n / i);
      }
    }

    scanner.close();
  }

}