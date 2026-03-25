import java.util.*;

public class SingleNumberTwo {

  public static int[] singleNumberBrute(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int[] result = new int[2];
    int idx = 0;

    for (int key : map.keySet()) {
      if (map.get(key) == 1) {
        result[idx++] = key;
      }
    }

    Arrays.sort(result);
    return result;
  }

  public static int[] singleNumberOptimal(int[] nums) {
    int xor = 0;

    for (int num : nums) {
      xor ^= num;
    }

    int rightmost = xor & -xor;

    int x = 0, y = 0;

    for (int num : nums) {
      if ((num & rightmost) != 0) {
        x ^= num;
      } else {
        y ^= num;
      }
    }

    int[] result = new int[] { x, y };
    Arrays.sort(result);
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    int[] brute = singleNumberBrute(nums);
    int[] optimal = singleNumberOptimal(nums);

    System.out.println("Brute: " + brute[0] + " " + brute[1]);
    System.out.println("Optimal: " + optimal[0] + " " + optimal[1]);

    sc.close();
  }
}