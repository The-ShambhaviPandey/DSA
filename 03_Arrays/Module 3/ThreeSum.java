import java.util.*;

public class ThreeSum {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    System.out.println("Triplets are: " + threeSumOptimal(nums));

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n^3)
  // Space Complexity: O(1) (excluding result storage)

  public static List<List<Integer>> threeSumBrute(int[] nums) {

    int n = nums.length;
    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {

          if (nums[i] + nums[j] + nums[k] == 0) {

            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(temp);
            set.add(temp);
          }
        }
      }
    }

    return new ArrayList<>(set);
  }

  // BETTER APPROACH (HashSet / 2-sum idea)
  // Time Complexity: O(n^2)
  // Space Complexity: O(n)

  public static List<List<Integer>> threeSumBetter(int[] nums) {

    int n = nums.length;

    Set<List<Integer>> ans = new HashSet<>();

    for (int i = 0; i < n; i++) {

      Set<Integer> hashset = new HashSet<>();

      for (int j = i + 1; j < n; j++) {

        int third = -(nums[i] + nums[j]);

        if (hashset.contains(third)) {

          List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
          Collections.sort(temp);
          ans.add(temp);
        }

        hashset.add(nums[j]);
      }
    }

    return new ArrayList<>(ans);
  }

  // OPTIMAL APPROACH (Sorting + Two Pointers)
  // Time Complexity: O(n^2)
  // Space Complexity: O(1) (excluding result)

  public static List<List<Integer>> threeSumOptimal(int[] nums) {

    int n = nums.length;

    Arrays.sort(nums);

    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {

      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      int left = i + 1;
      int right = n - 1;

      while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {

          ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

          left++;
          right--;

          while (left < right && nums[left] == nums[left - 1])
            left++;
          while (left < right && nums[right] == nums[right + 1])
            right--;
        }

        else if (sum < 0)
          left++;

        else
          right--;
      }
    }

    return ans;
  }
}