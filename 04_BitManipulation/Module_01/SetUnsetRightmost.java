import java.util.*;

public class SetUnsetRightmost {

  // Set rightmost unset bit
  public static int setRightmostUnsetBit(int n) {
    return n | (n + 1);
  }

  // Unset rightmost set bit
  public static int unsetRightmostSetBit(int n) {
    return n & (n - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n = sc.nextInt();

    int setBit = setRightmostUnsetBit(n);
    int unsetBit = unsetRightmostSetBit(n);

    System.out.println("After setting rightmost 0 bit: " + setBit);
    System.out.println("After unsetting rightmost 1 bit: " + unsetBit);

    sc.close();
  }
}