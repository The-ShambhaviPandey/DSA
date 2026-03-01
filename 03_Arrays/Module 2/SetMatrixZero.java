import java.util.*;

public class SetMatrixZero {

  // Brute force approach using O(m * n) space and O(m * n) time
  public static void setZeroesBrute(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    int[][] copy = new int[m][n];

    // Copy original
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        copy[i][j] = matrix[i][j];
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (copy[i][j] == 0) {

          // Set row to zero
          for (int col = 0; col < n; col++)
            matrix[i][col] = 0;

          // Set column to zero
          for (int row = 0; row < m; row++)
            matrix[row][j] = 0;
        }
      }
    }
  }

  // Better approach using O(m + n) space and O(m * n) time
  public static void setZeroesBetter(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];

    // Mark rows and columns
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    // Set zeroes
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  // Optimal approach using O(1) space and O(m * n) time
  public static void setZeroes(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    boolean firstColZero = false;

    // Step 1: Mark rows and columns
    for (int i = 0; i < m; i++) {

      if (matrix[i][0] == 0)
        firstColZero = true;

      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // Step 2: Use markers to set zeroes
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // Step 3: Handle first row
    if (matrix[0][0] == 0) {
      for (int j = 0; j < n; j++)
        matrix[0][j] = 0;
    }

    // Step 4: Handle first column
    if (firstColZero) {
      for (int i = 0; i < m; i++)
        matrix[i][0] = 0;
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows and columns:");
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] matrix = new int[m][n];
    System.out.println("Enter the matrix:");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    setZeroes(matrix);
    System.out.println("Matrix after setting zeroes:");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}