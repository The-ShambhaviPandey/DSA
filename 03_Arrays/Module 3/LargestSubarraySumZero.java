import java.util.*;

public class LargestSubarraySumZero {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Largest subarray length with sum 0: " + maxLenOptimal(arr));

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)

  public static int maxLenBrute(int[] arr) {

    int n = arr.length;
    int maxLen = 0;

    for (int i = 0; i < n; i++) {

      int sum = 0;

      for (int j = i; j < n; j++) {

        sum += arr[j];

        if (sum == 0) {
          maxLen = Math.max(maxLen, j - i + 1);
        }
      }
    }

    return maxLen;
  }

  // BETTER / OPTIMAL APPROACH (Prefix Sum + HashMap)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static int maxLenOptimal(int[] arr) {

    int n = arr.length;

    HashMap<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    for (int i = 0; i < n; i++) {

      sum += arr[i];

      if (sum == 0) {
        maxLen = i + 1;
      }

      if (map.containsKey(sum)) {
        int length = i - map.get(sum);
        maxLen = Math.max(maxLen, length);
      }

      else {
        map.put(sum, i);
      }
    }

    return maxLen;
  }
}