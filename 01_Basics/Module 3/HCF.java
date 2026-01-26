import java.util.*;

public class HCF {

  public static void main(String[] args) {

    System.out.println("Enter two numbers to find their HCF:");

    Scanner sc = new Scanner(System.in);

    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    num1 = Math.abs(num1);
    num2 = Math.abs(num2);

    if (num1 == 0 && num2 == 0) {
      System.out.println("HCF is undefined for both numbers zero");
    }

    int hcf = 1;

    // Brute Force Approach
    // for (int i = 1; i <= Math.min(num1, num2); i++) {
    // if (num1 % i == 0 && num2 % i == 0) {
    // hcf = i;
    // }

    // }

    // Better Approach
    // for (int i = Math.min(num1, num2); i >= 1; i--) {
    // if (num1 % i == 0 && num2 % i == 0) {
    // hcf = i;
    // break;
    // }
    // }

    // Optimal Approach - Euclidean Algorithm
    int a = num1;
    int b = num2;
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    hcf = a;

    System.out.println("HCF of " + num1 + " and " + num2 + " is: " + hcf);
    sc.close();

  }

}