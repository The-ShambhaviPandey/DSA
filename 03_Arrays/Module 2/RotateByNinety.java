import java.util.*;

public class RotateByNinety {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the matrix:");
    int n = sc.nextInt();

    int[][] matrix = new int[n][n];
    System.out.println("Enter the elements of the matrix:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    // Optimal Version
    rotate(matrix);

    System.out.println("Matrix after rotation:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    sc.close();
  }

  // Optimal approach using O(1) space and O(n^2) time
  public static void rotate(int[][] matrix) {

    int n = matrix.length;

    // Transpose
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // Reverse each row
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }
}
