import java.util.*;

public class DecimalToBinaryAndViceVersa {

  // Decimal to Binary
  public static String decimalToBinary(int n) {
    if (n == 0)
      return "0";

    StringBuilder binary = new StringBuilder();

    while (n > 0) {
      binary.append(n % 2); // or (n & 1)
      n = n / 2; // or n >> 1
    }

    return binary.reverse().toString();
  }

  // Binary to Decimal
  public static int binaryToDecimal(String binary) {
    int result = 0;
    int power = 0;

    for (int i = binary.length() - 1; i >= 0; i--) {
      int bit = binary.charAt(i) - '0';
      result += bit * Math.pow(2, power);
      power++;
    }

    return result;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Choose option:");
    System.out.println("1. Decimal to Binary");
    System.out.println("2. Binary to Decimal");

    int choice = sc.nextInt();

    if (choice == 1) {
      System.out.print("Enter decimal number: ");
      int n = sc.nextInt();

      String binary = decimalToBinary(n);
      System.out.println("Binary: " + binary);

    } else if (choice == 2) {
      System.out.print("Enter binary number: ");
      String binary = sc.next();

      int decimal = binaryToDecimal(binary);
      System.out.println("Decimal: " + decimal);

    } else {
      System.out.println("Invalid choice");
    }

    sc.close();
  }
}