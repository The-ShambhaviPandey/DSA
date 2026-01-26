import java.util.Scanner;

public class HollowButterfly {

  public static void main(String[] args) {

    System.out.println("Enter number of rows:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    // upper half
    // 1st part
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if (j == 1 || j == i)
          System.out.print("*");

        else
          System.out.print(" ");

      }

      int spaces = 2 * (n - i);
      for (int j = 1; j <= spaces; j++) {
        System.out.print(" ");
      }

      // 2nd part
      for (int j = 1; j <= i; j++) {
        if (j == 1 || j == i)
          System.out.print("*");

        else
          System.out.print(" ");

      }
      System.out.println();
    }

    // lower half
    // 1st part
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        if (j == 1 || j == i)
          System.out.print("*");

        else
          System.out.print(" ");

      }

      int spaces = 2 * (n - i);
      for (int j = 1; j <= spaces; j++) {
        System.out.print(" ");
      }

      // 2nd part
      for (int j = 1; j <= i; j++) {
        if (j == 1 || j == i)
          System.out.print("*");

        else
          System.out.print(" ");

      }
      System.out.println();
    }

  }

}
