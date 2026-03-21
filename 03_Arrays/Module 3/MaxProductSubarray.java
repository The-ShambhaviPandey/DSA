import java.util.*;

public class MaxProductSubarray {

  // BRUTE
  // Time: O(n^2), Space: O(1)
  static int brute(int[] arr, int n) {
    int maxProduct = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int product = 1;

      for (int j = i; j < n; j++) {
        product *= arr[j];
        maxProduct = Math.max(maxProduct, product);
      }
    }

    return maxProduct;
  }

  // OPTIMAL
  // Time: O(n), Space: O(1)
  static int optimal(int[] arr, int n) {
    int prefix = 1, suffix = 1;
    int maxProduct = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      // Reset when product becomes 0
      if (prefix == 0)
        prefix = 1;
      if (suffix == 0)
        suffix = 1;

      prefix *= arr[i];
      suffix *= arr[n - 1 - i];

      maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
    }

    return maxProduct;
  }

  // MAIN
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Input
    System.out.println("Enter the size of array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // Brute
    int bruteAns = brute(arr.clone(), n);
    System.out.println("Brute Max Product: " + bruteAns);

    // Optimal
    int optimalAns = optimal(arr.clone(), n);
    System.out.println("Optimal Max Product: " + optimalAns);

    sc.close();
  }
}