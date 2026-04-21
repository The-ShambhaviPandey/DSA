import java.util.Scanner;

public class SmallestDivisor {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(max(arr) * n), Space Complexity: O(1)

  public static int smallestDivisorBrute(int[] arr, int limit) {
    int max = arr[0];

    for (int num : arr) {
      max = Math.max(max, num);
    }

    for (int d = 1; d <= max; d++) {
      int sum = 0;

      for (int num : arr) {
        sum += (num + d - 1) / d;
      }

      if (sum <= limit) {
        return d;
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON ANSWER)
  // Time Complexity: O(n * log(max(arr))), Space Complexity: O(1)

  public static int smallestDivisorOptimal(int[] arr, int limit) {
    int max = arr[0];

    for (int num : arr) {
      max = Math.max(max, num);
    }

    int low = 1, high = max;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int sum = 0;

      for (int num : arr) {
        sum += (num + mid - 1) / mid;
      }

      if (sum <= limit) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
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

    System.out.println("Enter threshold limit:");
    int limit = sc.nextInt();

    sc.close();

    int brute = smallestDivisorBrute(arr, limit);
    System.out.println("Brute Result: " + brute);

    int optimal = smallestDivisorOptimal(arr, limit);
    System.out.println("Optimal Result: " + optimal);
  }
}