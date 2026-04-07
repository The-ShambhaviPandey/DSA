import java.util.Scanner;

public class FirstOccurrence {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int firstOccurrenceBrute(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i; // first match → return immediately
      }
    }
    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int firstOccurrenceOptimal(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == x) {
        ans = mid; // store answer
        high = mid - 1; // move left to find earlier occurrence
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

    int brute = firstOccurrenceBrute(arr, x);
    System.out.println("Brute Result: " + brute);

    int optimal = firstOccurrenceOptimal(arr, x);
    System.out.println("Optimal Result: " + optimal);
  }
}