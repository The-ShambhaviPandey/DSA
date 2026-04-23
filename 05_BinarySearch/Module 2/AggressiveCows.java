import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((max-min) * n), Space Complexity: O(1)

  public static boolean canPlaceCows(int[] arr, int k, int dist) {
    int cows = 1;
    int lastPlaced = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - lastPlaced >= dist) {
        cows++;
        lastPlaced = arr[i];
      }

      if (cows >= k) {
        return true;
      }
    }

    return false;
  }

  public static int aggressiveCowsBrute(int[] arr, int k) {
    Arrays.sort(arr);

    int low = 1;
    int high = arr[arr.length - 1] - arr[0];

    for (int dist = low; dist <= high; dist++) {
      if (!canPlaceCows(arr, k, dist)) {
        return dist - 1;
      }
    }

    return high;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(n * log(max-min)), Space Complexity: O(1)

  public static int aggressiveCowsOptimal(int[] arr, int k) {
    Arrays.sort(arr);

    int low = 1;
    int high = arr[arr.length - 1] - arr[0];
    int ans = 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (canPlaceCows(arr, k, mid)) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of stalls:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter stall positions:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter number of cows:");
    int k = sc.nextInt();

    sc.close();

    int brute = aggressiveCowsBrute(arr, k);
    System.out.println("Brute Result: " + brute);

    int optimal = aggressiveCowsOptimal(arr, k);
    System.out.println("Optimal Result: " + optimal);
  }
}