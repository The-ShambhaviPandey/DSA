import java.util.Scanner;

public class CapacityToShipPackages {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((sum-max) * n), Space Complexity: O(1)

  public static int shipBrute(int[] arr, int d) {
    int max = arr[0];
    int sum = 0;

    for (int num : arr) {
      max = Math.max(max, num);
      sum += num;
    }

    for (int cap = max; cap <= sum; cap++) {
      int days = countDays(arr, cap);

      if (days <= d) {
        return cap;
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH ON ANSWER)
  // Time Complexity: O(n * log(sum-max)), Space Complexity: O(1)

  public static int shipOptimal(int[] arr, int d) {
    int max = arr[0];
    int sum = 0;

    for (int num : arr) {
      max = Math.max(max, num);
      sum += num;
    }

    int low = max, high = sum;
    int ans = sum;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      int days = countDays(arr, mid);

      if (days <= d) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  // Helper Function

  public static int countDays(int[] arr, int cap) {
    int days = 1;
    int load = 0;

    for (int num : arr) {
      if (load + num <= cap) {
        load += num;
      } else {
        days++;
        load = num;
      }
    }

    return days;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Array size:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter weights:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter number of days:");
    int d = sc.nextInt();

    sc.close();

    int brute = shipBrute(arr, d);
    System.out.println("Brute Result: " + brute);

    int optimal = shipOptimal(arr, d);
    System.out.println("Optimal Result: " + optimal);
  }
}