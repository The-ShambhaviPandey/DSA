import java.util.Scanner;

public class SearchInRotatedSortedArrayII {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static boolean searchBrute(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == k) {
        return true;
      }
    }
    return false;
  }

  // OPTIMAL APPROACH (MODIFIED BINARY SEARCH)
  // Time Complexity: O(log n) average, O(n) worst case
  // Space Complexity: O(1)

  public static boolean searchOptimal(int[] arr, int k) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == k) {
        return true;
      }

      if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
        low++;
        high--;
      }

      else if (arr[low] <= arr[mid]) {
        if (k >= arr[low] && k < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }

      else {
        if (k > arr[mid] && k <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return false;
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

    System.out.println("Enter target value:");
    int k = sc.nextInt();

    sc.close();

    boolean brute = searchBrute(arr, k);
    System.out.println("Brute Result: " + brute);

    boolean optimal = searchOptimal(arr, k);
    System.out.println("Optimal Result: " + optimal);
  }
}