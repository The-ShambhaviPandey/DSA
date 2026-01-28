import java.util.*;

public class NRecursion {

  public static void printN(int n) {
    if (n == 0) {
      return;
    }

    // This prints numbers from 1 to n, for n to 1 use printN(n - 1) after the print
    // statement
    printN(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {

    System.out.println("Enter a number:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    printN(n);

    sc.close();
  }

}