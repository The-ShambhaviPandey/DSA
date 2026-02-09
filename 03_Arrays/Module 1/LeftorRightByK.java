import java.util.Arrays;
import java.util.Scanner;

public class LeftorRightByK {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();

    if (n == 0) {
      System.out.println("Empty array. Nothing to rotate.");
      sc.close();
      return;
    }

    int[] arr = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter the number of positions to rotate:");
    int k = sc.nextInt();
    k = k % n; // normalize k

    System.out.println("Enter the direction to rotate (L for left, R for right):");
    char direction = sc.next().charAt(0);

    System.out.println("Choose approach: 1 for Brute Force, 2 for Optimal:");
    int choice = sc.nextInt();

    if (choice == 1) {
      rotateBruteForce(arr, k, direction);
      System.out.println("Array after rotation (Brute Force): " + Arrays.toString(arr));
    } else if (choice == 2) {
      rotateOptimal(arr, k, direction);
      System.out.println("Array after rotation (Optimal): " + Arrays.toString(arr));
    } else {
      System.out.println("Invalid choice!");
    }

    sc.close();
  }

  // ==========================================================
  // BRUTE FORCE APPROACH
  // Time Complexity: O(n)
  // Space Complexity: O(k)
  // ==========================================================
  public static void rotateBruteForce(int[] arr, int k, char direction) {
    int n = arr.length;
    if (k == 0)
      return;

    // convert right rotation to left rotation
    if (direction == 'R' || direction == 'r') {
      k = n - k;
    }

    int[] temp = new int[k];

    // store first k elements
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }

    // shift remaining elements left
    for (int i = k; i < n; i++) {
      arr[i - k] = arr[i];
    }

    // copy temp to end
    for (int i = 0; i < k; i++) {
      arr[n - k + i] = temp[i];
    }
  }

  // ==========================================================
  // OPTIMAL APPROACH (Reversal Algorithm)
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  // ==========================================================
  public static void rotateOptimal(int[] arr, int k, char direction) {
    int n = arr.length;
    if (k == 0)
      return;

    // convert right rotation to left rotation
    if (direction == 'R' || direction == 'r') {
      k = n - k;
    }

    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);
  }

  // Utility function to reverse part of the array
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
