import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int findMinBrute(int[] arr) {
    int min = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }

    return min;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int findMinOptimal(int[] arr) {
    int low = 0, high = arr.length - 1;
    int ans = arr[0];

    while (low <= high) {
      // If current part is already sorted
      if (arr[low] <= arr[high]) {
        ans = Math.min(ans, arr[low]);
        break;
      }

      int mid = low + (high - low) / 2;

      // Left half sorted
      if (arr[low] <= arr[mid]) {
        ans = Math.min(ans, arr[low]);
        low = mid + 1;
      }
      // Right half sorted
      else {
        ans = Math.min(ans, arr[mid]);
        high = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Array size:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter Array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    sc.close();

    int brute = findMinBrute(arr);
    System.out.println("Brute Result: " + brute);

    int optimal = findMinOptimal(arr);
    System.out.println("Optimal Result: " + optimal);
  }
}