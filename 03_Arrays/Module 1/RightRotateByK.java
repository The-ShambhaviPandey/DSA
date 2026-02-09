import java.util.Arrays;
import java.util.Scanner;

public class RightRotateByK {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter the number of positions to rotate:");
    int k = sc.nextInt();

    sc.close();

    rightRotate(arr, k);

    System.out.println("Array after right rotation by " + k + " positions:");
    System.out.println(Arrays.toString(arr));
  }

  // Brute Force Approach: O(n+k) time complexity, O(k) space complexity
  public static void rightRotateBruteForce(int[] arr, int k) {
    int n = arr.length;

    if (n == 0)
      return; // Handle empty array case

    k = k % n; // Handle cases where k is greater than n

    if (k == 0)
      return;

    int[] temp = new int[k];

    // Store the last k elements in a temporary array
    for (int i = n - k; i < n; i++) {
      temp[i - (n - k)] = arr[i];
    }

    // Shift the remaining elements to the right
    for (int i = n - 1; i >= k; i--) {
      arr[i] = arr[i - k];
    }

    // Copy the temporary array back to the original array
    for (int i = 0; i < k; i++) {
      arr[i] = temp[i];
    }
  }

  // Optimal Approach: O(n) time complexity, O(1) space complexity
  public static void rightRotate(int[] arr, int k) {
    int n = arr.length;

    if (n == 0)
      return; // Handle empty array case

    k = k % n; // Handle cases where k is greater than n

    if (k == 0)
      return;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

}
