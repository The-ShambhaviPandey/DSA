import java.util.*;

public class IthBitSet {

  // Brute Force Method
  public static boolean isBitSetBrute(int n, int i) {
    String binary = Integer.toBinaryString(n);

    int len = binary.length();

    if (i >= len)
      return false;
    return binary.charAt(len - 1 - i) == '1';
  }

  // Optimal Method
  public static boolean isBitSetOptimal(int n, int i) {
    return ((n >> i) & 1) == 1;
  }

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n = sc.nextInt();

    System.out.print("Enter index (i): ");
    int i = sc.nextInt();

    // Brute
    boolean brute = isBitSetBrute(n, i);
    System.out.println("Brute: " + (brute ? "SET" : "NOT SET"));

    // Optimal
    boolean optimal = isBitSetOptimal(n, i);
    System.out.println("Optimal: " + (optimal ? "SET" : "NOT SET"));

    sc.close();
  }
}