import java.util.*;

public class XORLToR {

  public static int xorRangeBrute(int L, int R) {
    int xor = 0;
    for (int i = L; i <= R; i++) {
      xor ^= i;
    }
    return xor;
  }

  // XOR from 1 to n
  public static int xorUptoN(int n) {
    if (n % 4 == 0)
      return n;
    if (n % 4 == 1)
      return 1;
    if (n % 4 == 2)
      return n + 1;
    return 0;
  }

  public static int xorRangeOptimal(int L, int R) {
    return xorUptoN(R) ^ xorUptoN(L - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter L: ");
    int L = sc.nextInt();

    System.out.print("Enter R: ");
    int R = sc.nextInt();

    int brute = xorRangeBrute(L, R);
    int optimal = xorRangeOptimal(L, R);

    System.out.println("Brute XOR: " + brute);
    System.out.println("Optimal XOR: " + optimal);

    sc.close();
  }
}