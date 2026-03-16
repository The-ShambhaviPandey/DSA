import java.util.*;

public class FourSum {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    System.out.println("Enter target:");
    int target = sc.nextInt();

    System.out.println("Quadruplets are: " + fourSumOptimal(nums, target));

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n^4)
  // Space Complexity: O(1)

  public static List<List<Integer>> fourSumBrute(int[] nums, int target) {

    int n = nums.length;
    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          for (int l = k + 1; l < n; l++) {

            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {

              List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
              Collections.sort(temp);
              set.add(temp);
            }
          }
        }
      }
    }

    return new ArrayList<>(set);
  }

  // BETTER APPROACH (HashSet / 3-sum idea)
  // Time Complexity: O(n^3)
  // Space Complexity: O(n)

  public static List<List<Integer>> fourSumBetter(int[] nums, int target) {

    int n = nums.length;
    Set<List<Integer>> ans = new HashSet<>();

    for (int i = 0; i < n; i++) {

      for (int j = i + 1; j < n; j++) {

        Set<Integer> hashset = new HashSet<>();

        for (int k = j + 1; k < n; k++) {

          int fourth = target - (nums[i] + nums[j] + nums[k]);

          if (hashset.contains(fourth)) {

            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], fourth);
            Collections.sort(temp);
            ans.add(temp);
          }

          hashset.add(nums[k]);
        }
      }
    }

    return new ArrayList<>(ans);
  }

  // OPTIMAL APPROACH (Sorting + Two Pointers)
  // Time Complexity: O(n^3)
  // Space Complexity: O(1)

  public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {

    int n = nums.length;

    Arrays.sort(nums);

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {

      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      for (int j = i + 1; j < n; j++) {

        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;

        int left = j + 1;
        int right = n - 1;

        while (left < right) {

          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

          if (sum == target) {

            ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

            left++;
            right--;

            while (left < right && nums[left] == nums[left - 1])
              left++;
            while (left < right && nums[right] == nums[right + 1])
              right--;
          }

          else if (sum < target)
            left++;

          else
            right--;
        }
      }
    }

    return ans;
  }
}