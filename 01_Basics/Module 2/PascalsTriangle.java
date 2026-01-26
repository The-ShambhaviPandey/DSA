import java.util.Scanner;

public class PascalsTriangle {

  public static void main(String[] args) {

    System.out.println("Enter number of rows:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int j;

    for (int i = 0; i <= n; i++) {
      for (int k = 0; k < n - i; k++) {
        System.out.print(" ");
      }

      System.out.print("1");

      for (j = 1; j < (2 * i); j++) {
        if (j % 2 == 1) {
          System.out.print(" ");
        }

        else {
          System.out.print(i);
        }

      }

      if (j == (2 * i)) {
        System.out.print("1");
      }

      System.out.println();

    }
  }

}
