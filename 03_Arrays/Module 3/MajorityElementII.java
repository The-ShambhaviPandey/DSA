import java.util.*;

public class MajorityElementII {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    System.out.println("Majority elements in this array are: " + majorElement(nums));

    sc.close();
  }

  // BRUTE FORCE METHOD
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)

  public static List<Integer> majorElementBrute(int[] nums) {

    int n = nums.length;
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {

      if (result.contains(nums[i]))
        continue;

      int count = 0;

      for (int j = 0; j < n; j++) {
        if (nums[j] == nums[i])
          count++;
      }

      if (count > n / 3) {
        result.add(nums[i]);
      }
    }

    return result;
  }

  // BETTER APPROACH (HashMap counting)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static List<Integer> majorElementBETTER(int[] nums) {

    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > n / 3) {
        result.add(entry.getKey());
      }
    }

    return result;
  }

  // OPTIMAL APPROACH (Moore's Voting Algorithm Modified)
  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static List<Integer> majorElement(int[] nums) {

    int n = nums.length;

    int count1 = 0, count2 = 0;
    int candidate1 = 0, candidate2 = 0;

    for (int num : nums) {

      if (candidate1 == num)
        count1++;

      else if (candidate2 == num)
        count2++;

      else if (count1 == 0) {
        candidate1 = num;
        count1 = 1;
      }

      else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      }

      else {
        count1--;
        count2--;
      }
    }

    // verification step

    count1 = 0;
    count2 = 0;

    for (int num : nums) {
      if (num == candidate1)
        count1++;
      else if (num == candidate2)
        count2++;
    }

    List<Integer> result = new ArrayList<>();

    if (count1 > n / 3)
      result.add(candidate1);
    if (count2 > n / 3)
      result.add(candidate2);

    return result;
  }
}