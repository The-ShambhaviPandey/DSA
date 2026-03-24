import java.util.*;

public class SwapNumbersXOR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a: ");
    int a = sc.nextInt();

    System.out.print("Enter b: ");
    int b = sc.nextInt();

    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println("After swap:");
    System.out.println("a = " + a);
    System.out.println("b = " + b);

    sc.close();
  }
}