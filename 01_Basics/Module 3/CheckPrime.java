import java.util.Scanner;

public class CheckPrime {

  // Naive approach
  // public static void main(String[] args) {
  // Scanner scanner = new Scanner(System.in);
  // System.out.print("Enter a positive integer: ");
  // int n = scanner.nextInt();

  // if (isPrime(n)) {
  // System.out.println(n + " is a prime number.");
  // } else {
  // System.out.println(n + " is not a prime number.");
  // }

  // scanner.close();
  // }

  // public static boolean isPrime(int n) {
  // if (n <= 1) {
  // return false;
  // }
  // for (int i = 2; i * i <= n; i++) {
  // if (n % i == 0) {
  // return false;
  // }
  // }
  // return true;
  // }

  // Optimized approach
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int n = scanner.nextInt();
    if (isPrime(n)) {
      System.out.println(n + " is a prime number.");
    } else {
      System.out.println(n + " is not a prime number.");
    }
    scanner.close();
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

}
