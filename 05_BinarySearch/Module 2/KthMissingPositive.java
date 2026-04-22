import java.util.Scanner;

public class KthMissingPositive {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(answer), Space Complexity: O(1)

  public static int kthMissingBrute(int[] arr, int k) {
    int current = 1;
    int i = 0;

    while (k > 0) {
      if (i < arr.length && arr[i] == current) {
        i++;
      } else {
        k--;
        if (k == 0) {
          return current;
        }
      }
      current++;
    }

    return current;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int kthMissingOptimal(int[] arr, int k) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int missing = arr[mid] - (mid + 1);

      if (missing < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low + k;
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

    System.out.println("Enter value of k:");
    int k = sc.nextInt();

    sc.close();

    int brute = kthMissingBrute(arr, k);
    System.out.println("Brute Result: " + brute);

    int optimal = kthMissingOptimal(arr, k);
    System.out.println("Optimal Result: " + optimal);
  }
}