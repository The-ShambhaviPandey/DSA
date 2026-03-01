import java.util.*;

public class SubarraysEqualK {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the array elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the value of k:");
    int k = sc.nextInt();

    int count = countSubarraysEqualK(arr, k);
    System.out.println("Number of subarrays with sum equal to " + k + ": " + count);

    sc.close();
  }

  // Brute force approach using O(n^3) time
  public static int countSubarraysEqualKBrute(int[] arr, int k) {
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int sum = 0;
        for (int m = i; m <= j; m++) {
          sum += arr[m];
        }
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }

  // Better approach using O(n) time and O(n) space
  public static int countSubarraysEqualK(int[] arr, int k) {
    int count = 0;
    int sum = 0;
    HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0, 1); // Base case: one way to have sum = 0 (empty subarray)
    for (int num : arr) {
      sum += num;
      if (prefixSumCount.containsKey(sum - k)) {
        count += prefixSumCount.get(sum - k);
      }
      prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  // Optimal approach using O(n) time and O(1) space (only works for non-negative
  // numbers)
  public static int countSubarraysEqualKOptimal(int[] arr, int k) {
    int count = 0;
    int sum = 0;
    int left = 0;
    for (int right = 0; right < arr.length; right++) {
      sum += arr[right];
      while (sum > k && left <= right) {
        sum -= arr[left];
        left++;
      }
      if (sum == k) {
        count++;
      }
    }
    return count;
  }

}
