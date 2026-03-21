import java.util.*;

public class FindMissingRepeating {

  // BRUTE
  // Time: O(n^2), Space: O(1)
  static int[] brute(int[] arr, int n) {
    int repeating = -1, missing = -1;

    for (int i = 1; i <= n; i++) {
      int count = 0;

      for (int j = 0; j < n; j++) {
        if (arr[j] == i)
          count++;
      }

      if (count == 2)
        repeating = i;
      if (count == 0)
        missing = i;
    }

    return new int[] { repeating, missing };
  }

  // BETTER
  // Time: O(n), Space: O(n)
  static int[] better(int[] arr, int n) {
    int[] freq = new int[n + 1];

    for (int i = 0; i < n; i++) {
      freq[arr[i]]++;
    }

    int repeating = -1, missing = -1;

    for (int i = 1; i <= n; i++) {
      if (freq[i] == 2)
        repeating = i;
      if (freq[i] == 0)
        missing = i;
    }

    return new int[] { repeating, missing };
  }

  // OPTIMAL: I will do in bit manipulation
  // Time: O(n), Space: O(1)

  // My method
  // Time: O(n log n), Space: O(1)
  public static int[] myMethod(int[] arr, int n) {

    Arrays.sort(arr);
    int repeating = -1, missing = -1;

    for (int i = 1; i < n; i++) {
      if (arr[i] == arr[i - 1]) {
        repeating = arr[i];
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] != i + 1) {
        missing = i + 1;
        break;
      }
    }

    // Edge case: missing = n
    if (missing == -1)
      missing = n;

    return new int[] { repeating, missing };
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Input
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // Brute result
    int[] bruteAns = brute(arr, n);
    System.out.println("Brute -> Repeating: "
        + bruteAns[0] + ", Missing: " + bruteAns[1]);

    // Better result
    int[] betterAns = better(arr, n);
    System.out.println("Better -> Repeating: "
        + betterAns[0] + ", Missing: " + betterAns[1]);

    // My Method
    int[] myAns = myMethod(arr.clone(), n);
    System.out.println("MyMethod -> Repeating: "
        + myAns[0] + ", Missing: " + myAns[1]);

    sc.close();
  }
}