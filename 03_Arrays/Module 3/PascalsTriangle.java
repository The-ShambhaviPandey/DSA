import java.util.*;

public class PascalsTriangle {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of rows:");
    int n = sc.nextInt();

    System.out.println("Enter row and column:");
    int row = sc.nextInt();
    int col = sc.nextInt();

    System.out.println("Element is: " + findElement(row, col));

    System.out.println("Enter row to print:");
    int r = sc.nextInt();
    getRow(r);

    System.out.println("Full Pascal Triangle:");
    System.out.println(generate(n));

    sc.close();
  }

  public static long findElement(int row, int col) {

    int n = row - 1;
    int m = col - 1;

    long result = 1;

    for (int i = 0; i < m; i++) {
      result = result * (n - i) / (i + 1);
    }

    return result;
  }

  public static void getRow(int r) {

    int n = r - 1;
    long result = 1;

    System.out.print(result + " ");

    for (int i = 0; i < n; i++) {
      result = result * (n - i) / (i + 1);
      System.out.print(result + " ");
    }

    System.out.println();
  }

  public static List<List<Integer>> generate(int n) {

    List<List<Integer>> triangle = new ArrayList<>();

    for (int row = 0; row < n; row++) {

      List<Integer> current = new ArrayList<>();
      int value = 1;

      for (int col = 0; col <= row; col++) {
        current.add(value);
        value = value * (row - col) / (col + 1);
      }

      triangle.add(current);
    }

    return triangle;
  }
}