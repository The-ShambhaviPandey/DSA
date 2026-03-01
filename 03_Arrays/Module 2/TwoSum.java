import java.util.*;

public class TwoSum {

  // Brute Force Approach
  public static int[] twoSumBrute(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          System.out.println("Yes, the pair with target sum exists.");
          return new int[] { i, j };
        }
      }
    }
    System.out.println("No, the pair with target sum does not exist.");
    return new int[] { -1, -1 }; // Return -1 if no solution is found
  }

  // Better Approach using HashMap
  public static int[] twoSumHashMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        System.out.println("Yes, the pair with target sum exists.");
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    System.out.println("No, the pair with target sum does not exist.");
    return new int[] { -1, -1 }; // Return -1 if no solution is found
  }

  // Optimal Approach using Two Pointers (requires sorted array)
  public static int[] twoSumTwoPointers(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        System.out.println("Yes, the pair with target sum exists.");
        return new int[] { left, right };
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    System.out.println("No, the pair with target sum does not exist.");
    return new int[] { -1, -1 }; // Return -1 if no solution is found
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of elements in the array: ");
    int n = scanner.nextInt();

    int[] nums = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }

    System.out.print("Enter the target sum: ");
    int target = scanner.nextInt();

    int[] result = twoSumTwoPointers(nums, target);
    System.out.println("Indices: " + Arrays.toString(result));

    scanner.close();
  }
}