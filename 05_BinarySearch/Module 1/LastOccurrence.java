import java.util.Scanner;

public class LastOccurrence {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int lastOccurrenceBrute(int[] arr, int x) {
    int ans = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        ans = i; // keep updating to get last occurrence
      }
    }

    return ans;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int lastOccurrenceOptimal(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == x) {
        ans = mid; // store answer
        low = mid + 1; // move right to find last occurrence
      } else if (arr[mid] < x) {
        low = mid + 1;
      } else {
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

    System.out.println("Enter target value:");
    int x = sc.nextInt();

    sc.close();

    int brute = lastOccurrenceBrute(arr, x);
    System.out.println("Brute Result: " + brute);

    int optimal = lastOccurrenceOptimal(arr, x);
    System.out.println("Optimal Result: " + optimal);
  }
}