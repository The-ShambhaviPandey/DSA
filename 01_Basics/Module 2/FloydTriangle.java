import java.util.Scanner;

public class FloydTriangle {

  public static void main(String[] args) {

    int floyd = 1;
    System.out.println("Enter number of rows:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(floyd + " ");
        floyd += 1;
      }

      System.out.println();
    }

  }

}
