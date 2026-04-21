import java.util.Scanner;

public class KokoEatingBananas {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(max(arr) * n), Space Complexity: O(1)

  public static int kokoBrute(int[] arr, int h) {
    int max = arr[0];

    for (int num : arr) {
      max = Math.max(max, num);
    }

    for (int k = 1; k <= max; k++) {
      int totalHours = 0;

      for (int bananas : arr) {
        totalHours += (bananas + k - 1) / k;
      }

      if (totalHours <= h) {
        return k;
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON ANSWER)
  // Time Complexity: O(n * log(max(arr))), Space Complexity: O(1)

  public static int kokoOptimal(int[] arr, int h) {
    int max = arr[0];

    for (int num : arr) {
      max = Math.max(max, num);
    }

    int low = 1, high = max;
    int ans = max;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int totalHours = 0;

      for (int bananas : arr) {
        totalHours += (bananas + mid - 1) / mid;
      }

      if (totalHours <= h) {
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

    System.out.println("Enter number of piles:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter bananas in each pile:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter total hours:");
    int h = sc.nextInt();

    sc.close();

    int brute = kokoBrute(arr, h);
    System.out.println("Brute Result: " + brute);

    int optimal = kokoOptimal(arr, h);
    System.out.println("Optimal Result: " + optimal);
  }
}