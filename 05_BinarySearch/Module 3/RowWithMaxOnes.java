import java.util.Scanner;

public class RowWithMaxOnes {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n * m), Space Complexity: O(1)

  public static int rowWithMaxOnesBrute(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int maxCount = 0;
    int index = -1;

    for (int i = 0; i < n; i++) {
      int count = 0;

      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 1) {
          count++;
        }
      }

      if (count > maxCount) {
        maxCount = count;
        index = i;
      }
    }

    return index;
  }

  // LOWER BOUND FOR FIRST OCCURRENCE OF 1
  public static int lowerBound(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = arr.length;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] >= x) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON EACH ROW)
  // Time Complexity: O(n * log m), Space Complexity: O(1)

  public static int rowWithMaxOnesOptimal(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int maxCount = 0;
    int index = -1;

    for (int i = 0; i < n; i++) {

      int firstOne = lowerBound(mat[i], 1);
      int count = m - firstOne;

      if (count > maxCount) {
        maxCount = count;
        index = i;
      }
    }

    return index;
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

    int brute = rowWithMaxOnesBrute(mat);
    System.out.println("Brute Result: " + brute);

    int optimal = rowWithMaxOnesOptimal(mat);
    System.out.println("Optimal Result: " + optimal);
  }
}