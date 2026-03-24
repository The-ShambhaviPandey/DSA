import java.util.*;

public class CountSetBits {

  public static int countSetBitsBrute(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) == 1)
        count++;
      n = n >> 1;
    }
    return count;
  }

  public static int countSetBitsOptimal(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n = sc.nextInt();

    System.out.println("Brute: " + countSetBitsBrute(n));
    System.out.println("Optimal: " + countSetBitsOptimal(n));

    sc.close();
  }
}