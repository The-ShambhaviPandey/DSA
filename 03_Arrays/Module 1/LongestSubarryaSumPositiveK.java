import java.util.*;

public class LongestSubarryaSumPositiveK {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array and the value of k: ");

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println("Enter the elements of the array: ");

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int[] result = longestSubarraySumK(arr, k);

    if (result.length == 0) {
      System.out.println("No subarray found.");
    } else {
      System.out.println("Longest subarray:");
      for (int num : result) {
        System.out.print(num + " ");
      }
    }
    sc.close();

  }

  // Brute Force Approach
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public static int longestSubarraySumKBrute(int arr[], int k) {
    int maxLength = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          maxLength = Math.max(maxLength, j - i + 1);
        }
      }
    }
    return maxLength;
  }

  // Optimal Approach -> Using Two Pointers
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public static int[] longestSubarraySumK(int arr[], int k) {

    int left = 0, sum = 0;
    int maxLength = 0;
    int start = -1, end = -1;

    for (int right = 0; right < arr.length; right++) {
      sum += arr[right];

      while (sum > k && left <= right) {
        sum -= arr[left];
        left++;
      }

      if (sum == k && (right - left + 1) > maxLength) {
        maxLength = right - left + 1;
        start = left;
        end = right;
      }
    }

    if (start == -1)
      return new int[0]; // no subarray found

    return Arrays.copyOfRange(arr, start, end + 1);
  }
}
