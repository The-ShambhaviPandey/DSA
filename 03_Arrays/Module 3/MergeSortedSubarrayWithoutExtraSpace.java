import java.util.*;

public class MergeSortedSubarrayWithoutExtraSpace {

  // TIME: O(m + n)
  // SPACE: O(1)

  // Merge nums2 into nums1 (in-place)
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = m - 1; // last element in nums1
    int j = n - 1; // last element in nums2
    int k = m + n - 1; // last position in nums1

    // Fill from the back
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }

    // Copy remaining nums2 elements
    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Input sizes
    int m = sc.nextInt(); // size of nums1 (actual elements)
    int n = sc.nextInt(); // size of nums2

    int[] nums1 = new int[m + n];
    int[] nums2 = new int[n];

    // Input nums1 elements
    for (int i = 0; i < m; i++) {
      nums1[i] = sc.nextInt();
    }

    // remaining positions are already 0 (extra space)

    // Input nums2 elements
    for (int i = 0; i < n; i++) {
      nums2[i] = sc.nextInt();
    }

    // Call merge
    MergeSortedSubarrayWithoutExtraSpace obj = new MergeSortedSubarrayWithoutExtraSpace();

    obj.merge(nums1, m, nums2, n);

    // Output result
    System.out.println(Arrays.toString(nums1));

    sc.close();
  }
}