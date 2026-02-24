import java.util.*;

public class LongestSubarrayWithSumZero {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int maxLength = longestSubarrayWithSumZero(arr);
    System.out.println("The length of the longest subarray with sum zero is: " + maxLength);

    sc.close();
  }

  // Brute Force Approach
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  public static int longestSubarrayWithSumZeroBrute(int[] arr) {
    int maxLength = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == 0) {
          maxLength = Math.max(maxLength, j - i + 1);
        }
      }
    }
    return maxLength;
  }

  // Optimal Approach - using two pointers and a HashMap
  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public static int longestSubarrayWithSumZero(int[] arr) {
    int maxLength = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // To handle the case when the subarray starts from index 0
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (map.containsKey(sum)) {
        maxLength = Math.max(maxLength, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }
    return maxLength;
  }
}
