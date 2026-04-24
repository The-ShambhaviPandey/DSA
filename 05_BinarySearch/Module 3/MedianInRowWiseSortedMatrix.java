import java.util.Arrays;
import java.util.Scanner;

public class MedianInRowWiseSortedMatrix {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((m*n) log(m*n)), Space Complexity: O(m*n)

  public static int medianBrute(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    int[] arr = new int[rows * cols];
    int index = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        arr[index++] = mat[i][j];
      }
    }

    Arrays.sort(arr);

    return arr[(rows * cols) / 2];
  }

  // COUNT OF ELEMENTS <= target IN ONE ROW

  public static int upperBound(int[] row, int target) {
    int low = 0, high = row.length - 1;
    int ans = row.length;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (row[mid] > target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON ANSWER)
  // Time Complexity: O(32 * rows * log(cols)), Space Complexity: O(1)

  public static int medianOptimal(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    for (int i = 0; i < rows; i++) {
      low = Math.min(low, mat[i][0]);
      high = Math.max(high, mat[i][cols - 1]);
    }

    int req = (rows * cols) / 2;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      int count = 0;

      for (int i = 0; i < rows; i++) {
        count += upperBound(mat[i], mid);
      }

      if (count <= req) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of rows:");
    int m = sc.nextInt();

    System.out.println("Enter number of columns:");
    int n = sc.nextInt();

    int[][] mat = new int[m][n];

    System.out.println("Enter matrix row-wise sorted:");

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = sc.nextInt();
      }
    }

    sc.close();

    int brute = medianBrute(mat);
    System.out.println("Brute Result: " + brute);

    int optimal = medianOptimal(mat);
    System.out.println("Optimal Result: " + optimal);
  }
}