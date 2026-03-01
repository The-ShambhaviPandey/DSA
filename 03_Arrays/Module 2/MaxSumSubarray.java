import java.util.*;

public class MaxSumSubarray {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Maximum Subarray Sum: " + maxSumSubarray(arr));
    sc.close();
  }

  // Brute Force Approach - O(n^2)
  public static int maxSumSubarrayBrute(int[] arr) {

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      int currentSum = 0;

      for (int j = i; j < arr.length; j++) {
        currentSum += arr[j];
        maxSum = Math.max(maxSum, currentSum);
      }
    }

    return maxSum;
  }

  // Optimal Approach - Kadane's Algorithm - O(n)
  public static int maxSumSubarray(int[] arr) {

    int currentSum = arr[0];
    int maxSum = arr[0];

    for (int i = 1; i < arr.length; i++) {
      currentSum = Math.max(arr[i], currentSum + arr[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }
}