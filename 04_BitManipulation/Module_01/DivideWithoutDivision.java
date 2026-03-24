import java.util.*;

public class DivideWithoutDivision {

  public static int divideBrute(int dividend, int divisor) {
    if (divisor == 0)
      throw new ArithmeticException("Divide by zero");

    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    int count = 0;
    while (dividend >= divisor) {
      dividend -= divisor;
      count++;
    }

    return sign * count;
  }

  public static int divideOptimal(int dividend, int divisor) {
    if (divisor == 0)
      throw new ArithmeticException("Divide by zero");

    if (dividend == Integer.MIN_VALUE && divisor == -1)
      return Integer.MAX_VALUE;

    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

    long n = Math.abs((long) dividend);
    long d = Math.abs((long) divisor);

    int quotient = 0;

    while (n >= d) {
      int count = 0;
      while (n >= (d << (count + 1))) {
        count++;
      }

      quotient += (1 << count);
      n -= (d << count);
    }

    return sign * quotient;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter dividend: ");
    int dividend = sc.nextInt();

    System.out.print("Enter divisor: ");
    int divisor = sc.nextInt();

    System.out.println("Brute: " + divideBrute(dividend, divisor));
    System.out.println("Optimal: " + divideOptimal(dividend, divisor));

    sc.close();
  }
}