import java.util.Scanner;

public class SearchIn2DMatrix {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n * m), Space Complexity: O(1)

  public static boolean searchBrute(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == target) {
          return true;
        }
      }
    }

    return false;
  }

  // BETTER APPROACH (ROW SELECTION + BINARY SEARCH)
  // Time Complexity: O(n + log m), Space Complexity: O(1)

  public static boolean searchBetter(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;

    for (int i = 0; i < n; i++) {

      if (target >= mat[i][0] && target <= mat[i][m - 1]) {

        int low = 0, high = m - 1;

        while (low <= high) {
          int mid = low + (high - low) / 2;

          if (mat[i][mid] == target) {
            return true;
          } else if (mat[i][mid] < target) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
      }
    }

    return false;
  }

  // OPTIMAL APPROACH (TREAT MATRIX AS 1D ARRAY)
  // Time Complexity: O(log(n * m)), Space Complexity: O(1)

  public static boolean searchOptimal(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;

    int low = 0, high = (n * m) - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int row = mid / m;
      int col = mid % m;

      if (mat[row][col] == target) {
        return true;
      } else if (mat[row][col] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return false;
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

    System.out.println("Enter target:");
    int target = sc.nextInt();

    sc.close();

    boolean brute = searchBrute(mat, target);
    System.out.println("Brute Result: " + brute);

    boolean better = searchBetter(mat, target);
    System.out.println("Better Result: " + better);

    boolean optimal = searchOptimal(mat, target);
    System.out.println("Optimal Result: " + optimal);
  }
}