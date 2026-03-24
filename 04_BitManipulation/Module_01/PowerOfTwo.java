import java.util.*;

public class PowerOfTwo {

  // Optimal Method
  public static boolean isPowerOfTwo(int n) {
    return (n > 0) && ((n & (n - 1)) == 0);
  }

  // Brute Method
  public static boolean isPowerOfTwoBrute(int n) {
    if (n <= 0)
      return false;

    while (n % 2 == 0) {
      n = n / 2;
    }

    return n == 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n = sc.nextInt();

    // Brute
    if (isPowerOfTwoBrute(n)) {
      System.out.println("Brute: Power of 2");
    } else {
      System.out.println("Brute: Not Power of 2");
    }

    // Optimal
    if (isPowerOfTwo(n)) {
      System.out.println("Optimal: Power of 2");
    } else {
      System.out.println("Optimal: Not Power of 2");
    }

    sc.close();
  }
}