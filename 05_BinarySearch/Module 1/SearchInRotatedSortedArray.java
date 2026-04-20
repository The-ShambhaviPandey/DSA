import java.util.Scanner;

public class SearchInRotatedSortedArray {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int searchBrute(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == k) {
        return i;
      }
    }
    return -1;
  }

  // OPTIMAL APPROACH (MODIFIED BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int searchOptimal(int[] arr, int k) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == k) {
        return mid;
      }

      // Left half is sorted
      if (arr[low] <= arr[mid]) {
        if (k >= arr[low] && k < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      // Right half is sorted
      else {
        if (k > arr[mid] && k <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
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

    int brute = searchBrute(arr, k);
    System.out.println("Brute Result: " + brute);

    int optimal = searchOptimal(arr, k);
    System.out.println("Optimal Result: " + optimal);
  }
}