import java.util.*;

public class PowerFunction {

  public static double powerOptimal(double x, int n) {
    long N = n;
    double result = 1.0;

    if (N < 0) {
      x = 1 / x;
      N = -N;
    }

    while (N > 0) {
      // if odd
      if ((N & 1) == 1) {
        result *= x;
      }

      x *= x;
      N >>= 1;
    }

    return result;
  }

  public static double powerBrute(double x, int n) {
    double result = 1.0;
    for (int i = 0; i < Math.abs(n); i++) {
      result *= x;
    }
    if (n < 0)
      return 1.0 / result;
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter x: ");
    double x = sc.nextDouble();

    System.out.print("Enter n: ");
    int n = sc.nextInt();

    System.out.println("Brute: " + powerBrute(x, n));
    System.out.println("Optimal: " + powerOptimal(x, n));

    sc.close();
  }
}