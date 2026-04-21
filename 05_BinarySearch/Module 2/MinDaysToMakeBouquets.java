import java.util.Scanner;

public class MinDaysToMakeBouquets {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((max-min+1) * n), Space Complexity: O(1)

  public static int minDaysBrute(int[] arr, int m, int k) {
    int n = arr.length;

    if ((long) m * k > n) {
      return -1;
    }

    int min = arr[0], max = arr[0];

    for (int day : arr) {
      min = Math.min(min, day);
      max = Math.max(max, day);
    }

    for (int day = min; day <= max; day++) {
      if (canMake(arr, day, m, k)) {
        return day;
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON ANSWER)
  // Time Complexity: O(n * log(max-min)), Space Complexity: O(1)

  public static int minDaysOptimal(int[] arr, int m, int k) {
    int n = arr.length;

    if ((long) m * k > n) {
      return -1;
    }

    int min = arr[0], max = arr[0];

    for (int day : arr) {
      min = Math.min(min, day);
      max = Math.max(max, day);
    }

    int low = min, high = max;
    int ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (canMake(arr, mid, m, k)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  // Helper Function

  public static boolean canMake(int[] arr, int day, int m, int k) {
    int count = 0;
    int bouquets = 0;

    for (int bloomDay : arr) {
      if (bloomDay <= day) {
        count++;
      } else {
        bouquets += count / k;
        count = 0;
      }
    }

    bouquets += count / k;

    return bouquets >= m;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of roses:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter bloom days:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter number of bouquets:");
    int m = sc.nextInt();

    System.out.println("Enter roses per bouquet:");
    int k = sc.nextInt();

    sc.close();

    int brute = minDaysBrute(arr, m, k);
    System.out.println("Brute Result: " + brute);

    int optimal = minDaysOptimal(arr, m, k);
    System.out.println("Optimal Result: " + optimal);
  }
}