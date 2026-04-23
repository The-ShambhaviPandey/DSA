import java.util.Scanner;

public class KthElementTwoSortedArrays {

  // BRUTE FORCE APPROACH (MERGE BOTH ARRAYS)
  // Time Complexity: O(m + n), Space Complexity: O(m + n)

  public static int kthElementBrute(int[] a, int[] b, int k) {
    int m = a.length, n = b.length;
    int[] merged = new int[m + n];

    int i = 0, j = 0, idx = 0;

    while (i < m && j < n) {
      if (a[i] <= b[j]) {
        merged[idx++] = a[i++];
      } else {
        merged[idx++] = b[j++];
      }
    }

    while (i < m)
      merged[idx++] = a[i++];
    while (j < n)
      merged[idx++] = b[j++];

    return merged[k - 1];
  }

  // OPTIMAL APPROACH (BINARY SEARCH PARTITION)
  // Time Complexity: O(log(min(m,n))), Space Complexity: O(1)

  public static int kthElementOptimal(int[] a, int[] b, int k) {

    if (a.length > b.length) {
      return kthElementOptimal(b, a, k);
    }

    int m = a.length, n = b.length;

    int low = Math.max(0, k - n);
    int high = Math.min(k, m);

    while (low <= high) {

      int cut1 = low + (high - low) / 2;
      int cut2 = k - cut1;

      int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
      int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];

      int right1 = (cut1 == m) ? Integer.MAX_VALUE : a[cut1];
      int right2 = (cut2 == n) ? Integer.MAX_VALUE : b[cut2];

      if (left1 <= right2 && left2 <= right1) {
        return Math.max(left1, left2);
      } else if (left1 > right2) {
        high = cut1 - 1;
      } else {
        low = cut1 + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of first array:");
    int m = sc.nextInt();

    int[] a = new int[m];

    System.out.println("Enter first sorted array:");
    for (int i = 0; i < m; i++) {
      a[i] = sc.nextInt();
    }

    System.out.println("Enter size of second array:");
    int n = sc.nextInt();

    int[] b = new int[n];

    System.out.println("Enter second sorted array:");
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }

    System.out.println("Enter value of k:");
    int k = sc.nextInt();

    sc.close();

    int brute = kthElementBrute(a, b, k);
    System.out.println("Brute Result: " + brute);

    int optimal = kthElementOptimal(a, b, k);
    System.out.println("Optimal Result: " + optimal);
  }
}