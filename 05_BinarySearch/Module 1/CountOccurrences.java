import java.util.Scanner;

public class CountOccurrences {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int countBrute(int[] arr, int x) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        count++;
      }
    }

    return count;
  }

  // OPTIMAL APPROACH (USING BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int firstOccurrence(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == x) {
        ans = mid;
        high = mid - 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }

  public static int lastOccurrence(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == x) {
        ans = mid;
        low = mid + 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }

  public static int countOptimal(int[] arr, int x) {
    int first = firstOccurrence(arr, x);
    if (first == -1)
      return 0;

    int last = lastOccurrence(arr, x);
    return last - first + 1;
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
    int x = sc.nextInt();

    sc.close();

    int brute = countBrute(arr, x);
    System.out.println("Brute Count: " + brute);

    int optimal = countOptimal(arr, x);
    System.out.println("Optimal Count: " + optimal);
  }
}