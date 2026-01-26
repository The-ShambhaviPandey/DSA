import java.util.*;

public class HalfPyramid {

  public static void main(String[] args) {

    System.out.println("Enter number of rows:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // System.out.println("Enter number of columns:");
    // int m = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {

        System.out.print("*");

      }
      System.out.println();

    }

    sc.close();
  }
}
