import java.util.Scanner;

public class CountRotationsInSortedArray {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int countRotationsBrute(int[] arr) {
    int minIndex = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[minIndex]) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int countRotationsOptimal(int[] arr) {
    int low = 0, high = arr.length - 1;
    int minIndex = 0;

    while (low <= high) {

      // If current part is already sorted
      if (arr[low] <= arr[high]) {
        if (arr[low] < arr[minIndex]) {
          minIndex = low;
        }
        break;
      }

      int mid = low + (high - low) / 2;

      // Left half sorted
      if (arr[low] <= arr[mid]) {
        if (arr[low] < arr[minIndex]) {
          minIndex = low;
        }
        low = mid + 1;
      }

      // Right half sorted
      else {
        if (arr[mid] < arr[minIndex]) {
          minIndex = mid;
        }
        high = mid - 1;
      }
    }

    return minIndex;
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

    int brute = countRotationsBrute(arr);
    System.out.println("Brute Result: " + brute);

    int optimal = countRotationsOptimal(arr);
    System.out.println("Optimal Result: " + optimal);
  }
}