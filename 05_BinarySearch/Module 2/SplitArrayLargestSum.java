import java.util.Scanner;

public class SplitArrayLargestSum {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((sum-max) * n), Space Complexity: O(1)

  public static int countPartitions(int[] arr, int maxSum) {
    int partitions = 1;
    int currentSum = 0;

    for (int i = 0; i < arr.length; i++) {

      if (currentSum + arr[i] <= maxSum) {
        currentSum += arr[i];
      } else {
        partitions++;
        currentSum = arr[i];
      }

    }

    return partitions;
  }

  public static int splitArrayBrute(int[] arr, int k) {

    int n = arr.length;

    if (k > n) {
      return -1;
    }

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < n; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }

    for (int maxSum = low; maxSum <= high; maxSum++) {
      if (countPartitions(arr, maxSum) <= k) {
        return maxSum;
      }
    }

    return low;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(n * log(sum-max)), Space Complexity: O(1)

  public static int splitArrayOptimal(int[] arr, int k) {

    int n = arr.length;

    if (k > n) {
      return -1;
    }

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < n; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }

    int ans = high;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (countPartitions(arr, mid) <= k) {
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

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter value of k:");
    int k = sc.nextInt();

    sc.close();

    int brute = splitArrayBrute(arr, k);
    System.out.println("Brute Result: " + brute);

    int optimal = splitArrayOptimal(arr, k);
    System.out.println("Optimal Result: " + optimal);
  }
}