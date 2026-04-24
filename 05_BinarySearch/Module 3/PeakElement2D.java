import java.util.Scanner;

public class PeakElement2D {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n * m), Space Complexity: O(1)

  public static int[] findPeakBrute(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        int top = (i > 0) ? mat[i - 1][j] : -1;
        int bottom = (i < n - 1) ? mat[i + 1][j] : -1;
        int left = (j > 0) ? mat[i][j - 1] : -1;
        int right = (j < m - 1) ? mat[i][j + 1] : -1;

        if (mat[i][j] > top &&
            mat[i][j] > bottom &&
            mat[i][j] > left &&
            mat[i][j] > right) {
          return new int[] { i, j };
        }
      }
    }

    return new int[] { -1, -1 };
  }

  // FIND ROW INDEX OF MAX ELEMENT IN COLUMN

  public static int maxRowIndex(int[][] mat, int col) {
    int n = mat.length;
    int rowIndex = 0;

    for (int i = 1; i < n; i++) {
      if (mat[i][col] > mat[rowIndex][col]) {
        rowIndex = i;
      }
    }

    return rowIndex;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON COLUMNS)
  // Time Complexity: O(n * log m), Space Complexity: O(1)

  public static int[] findPeakOptimal(int[][] mat) {
    // int n = mat.length;
    int m = mat[0].length;

    int low = 0, high = m - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      int row = maxRowIndex(mat, mid);

      int left = (mid > 0) ? mat[row][mid - 1] : -1;
      int right = (mid < m - 1) ? mat[row][mid + 1] : -1;

      if (mat[row][mid] > left && mat[row][mid] > right) {
        return new int[] { row, mid };
      } else if (left > mat[row][mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of rows:");
    int n = sc.nextInt();

    System.out.println("Enter number of columns:");
    int m = sc.nextInt();

    int[][] mat = new int[n][m];

    System.out.println("Enter matrix:");

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = sc.nextInt();
      }
    }

    sc.close();

    int[] brute = findPeakBrute(mat);
    System.out.println("Brute Result: [" + brute[0] + ", " + brute[1] + "]");

    int[] optimal = findPeakOptimal(mat);
    System.out.println("Optimal Result: [" + optimal[0] + ", " + optimal[1] + "]");
  }
}