import java.util.*;

public class NextPermutation {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // Optimal Version
    nextPermutation(arr);

    System.out.println("Next permutation (Optimal):");
    for (int num : arr) {
      System.out.print(num + " ");
    }

    // Brute Version Example
    // int[] bruteResult = nextPermutationBrute(arr.clone());
    // System.out.println("\nNext permutation (Brute):");
    // for (int num : bruteResult) {
    // System.out.print(num + " ");
    // }

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n! * n)
  // Space Complexity: O(n! * n)
  public static int[] nextPermutationBrute(int[] arr) {

    List<List<Integer>> perms = new ArrayList<>();
    permute(arr, 0, perms);

    // Sort lexicographically
    perms.sort((a, b) -> {
      for (int i = 0; i < a.size(); i++) {
        if (!a.get(i).equals(b.get(i))) {
          return a.get(i) - b.get(i);
        }
      }
      return 0;
    });

    List<Integer> current = new ArrayList<>();
    for (int num : arr)
      current.add(num);

    for (int i = 0; i < perms.size(); i++) {
      if (perms.get(i).equals(current)) {
        if (i == perms.size() - 1)
          return toArray(perms.get(0)); // wrap to first
        else
          return toArray(perms.get(i + 1));
      }
    }

    return arr;
  }

  private static void permute(int[] nums, int start, List<List<Integer>> all) {
    if (start == nums.length) {
      List<Integer> temp = new ArrayList<>();
      for (int num : nums)
        temp.add(num);
      all.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      swap(nums, i, start);
      permute(nums, start + 1, all);
      swap(nums, i, start);
    }
  }

  private static int[] toArray(List<Integer> list) {
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      res[i] = list.get(i);
    return res;
  }

  // OPTIMAL
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  public static void nextPermutation(int[] arr) {

    int n = arr.length;

    // Step 1: Find breakpoint
    int i = n - 2;
    while (i >= 0 && arr[i] >= arr[i + 1]) {
      i--;
    }

    // Step 2: Swap if breakpoint exists
    if (i >= 0) {
      int j = n - 1;
      while (arr[j] <= arr[i]) {
        j--;
      }
      swap(arr, i, j);
    }

    // Step 3: Reverse suffix
    reverse(arr, i + 1, n - 1);
  }

  private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
      swap(arr, left, right);
      left++;
      right--;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}