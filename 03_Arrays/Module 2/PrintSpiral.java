import java.util.*;

public class PrintSpiral {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of rows:");
    int m = sc.nextInt();

    System.out.println("Enter the number of columns:");
    int n = sc.nextInt();

    int[][] matrix = new int[m][n];
    System.out.println("Enter the elements of the matrix:");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    System.out.println("Spiral order of the matrix:");
    printSpiral(matrix);

    sc.close();
  }

  public static void printSpiral(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      // Traverse from left to right
      for (int j = left; j <= right; j++) {
        System.out.print(matrix[top][j] + " ");
      }
      top++;

      // Traverse from top to bottom
      for (int i = top; i <= bottom; i++) {
        System.out.print(matrix[i][right] + " ");
      }
      right--;

      if (top <= bottom) {
        // Traverse from right to left
        for (int j = right; j >= left; j--) {
          System.out.print(matrix[bottom][j] + " ");
        }
        bottom--;
      }

      if (left <= right) {
        // Traverse from bottom to top
        for (int i = bottom; i >= top; i--) {
          System.out.print(matrix[i][left] + " ");
        }
        left++;
      }
    }
  }
}
