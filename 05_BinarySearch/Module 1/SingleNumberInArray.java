import java.util.Scanner;

public class SingleNumberInArray {

  // BRUTE FORCE APPROACH (LINEAR SEARCH)
  // Time Complexity: O(n^2), Space Complexity: O(1)

  public static int singleNumberBrute(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int count = 0;

      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }

      if (count == 1) {
        return arr[i];
      }
    }

    return -1;
  }

  // BETTER APPROACH (XOR)
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int singleNumberBetter(int[] arr) {
    int xor = 0;

    for (int num : arr) {
      xor ^= num;
    }

    return xor;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Array must be sorted
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int singleNumberOptimal(int[] arr) {
    int n = arr.length;

    if (n == 1)
      return arr[0];
    if (arr[0] != arr[1])
      return arr[0];
    if (arr[n - 1] != arr[n - 2])
      return arr[n - 1];

    int low = 1, high = n - 2;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
        return arr[mid];
      }

      if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
          (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Array size:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter Array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    sc.close();

    int brute = singleNumberBrute(arr);
    System.out.println("Brute Result: " + brute);

    int better = singleNumberBetter(arr);
    System.out.println("Better Result: " + better);

    int optimal = singleNumberOptimal(arr);
    System.out.println("Optimal Result: " + optimal);
  }
}