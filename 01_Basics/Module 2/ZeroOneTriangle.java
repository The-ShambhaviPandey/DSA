import java.util.Scanner;

public class ZeroOneTriangle {
  public static void main(String[] args) {

    System.out.println("Enter number of rows:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 != 0)
          System.out.print(0 + " ");

        else
          System.out.print(1 + " ");

      }
      System.out.println();
    }

  }
}
