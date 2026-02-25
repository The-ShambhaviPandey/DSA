import java.util.*;

public class UnionOfSortedArrays {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of both arrays:");
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr1 = new int[n];
    int[] arr2 = new int[m];

    System.out.println("Enter elements of first array:");
    for (int i = 0; i < n; i++) {
      arr1[i] = sc.nextInt();
    }

    System.out.println("Enter elements of second array:");
    for (int i = 0; i < m; i++) {
      arr2[i] = sc.nextInt();
    }

    int[] result = unionOfSortedArrays(arr1, arr2);

    for (int num : result) {
      System.out.print(num + " ");
    }

    sc.close();
  }

  // Brute Force - Using Sets
  // Time:O((n+m) log(n+m))
  // Space: O(n + m) in worst case when all elements are unique
  public static int[] unionBrute(int[] arr1, int[] arr2) {
    Set<Integer> set = new TreeSet<>(); // keeps sorted order

    for (int num : arr1)
      set.add(num);
    for (int num : arr2)
      set.add(num);

    int[] result = new int[set.size()];
    int index = 0;

    for (int num : set) {
      result[index++] = num;
    }

    return result;
  }

  // Optimal - Two Pointers
  // Time Complexity: O(n + m)
  // Space Complexity: O(n + m) in worst case when all elements are unique
  public static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {

    int n = arr1.length;
    int m = arr2.length;

    int[] union = new int[n + m];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {

      int val;

      if (arr1[i] < arr2[j]) {
        val = arr1[i++];
      } else if (arr1[i] > arr2[j]) {
        val = arr2[j++];
      } else {
        val = arr1[i];
        i++;
        j++;
      }

      if (k == 0 || union[k - 1] != val) {
        union[k++] = val;
      }
    }

    while (i < n) {
      if (k == 0 || union[k - 1] != arr1[i]) {
        union[k++] = arr1[i];
      }
      i++;
    }

    while (j < m) {
      if (k == 0 || union[k - 1] != arr2[j]) {
        union[k++] = arr2[j];
      }
      j++;
    }

    return Arrays.copyOf(union, k);
  }
}