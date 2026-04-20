import java.util.Scanner;

public class FindPeakElement {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int findPeakBrute(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {

      if (i == 0) {
        if (n == 1 || arr[i] > arr[i + 1]) {
          return i;
        }
      }

      else if (i == n - 1) {
        if (arr[i] > arr[i - 1]) {
          return i;
        }
      }

      else {
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
          return i;
        }
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int findPeakOptimal(int[] arr) {
    int n = arr.length;

    if (n == 1)
      return 0;
    if (arr[0] > arr[1])
      return 0;
    if (arr[n - 1] > arr[n - 2])
      return n - 1;

    int low = 1, high = n - 2;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      }

      if (arr[mid] > arr[mid - 1]) {
        low = mid + 1;
      } else {
        high = mid - 1;
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

    sc.close();

    int brute = findPeakBrute(arr);
    System.out.println("Brute Result: " + brute);

    int optimal = findPeakOptimal(arr);
    System.out.println("Optimal Result: " + optimal);
  }
}