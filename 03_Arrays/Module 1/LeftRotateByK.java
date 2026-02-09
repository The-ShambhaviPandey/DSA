import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateByK {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter the value of k:");
    int k = sc.nextInt();
    sc.close();

    rotateArray(arr, k);
    System.out.println("Array after left rotation: " + Arrays.toString(arr));
  }

  // BRUTE FORCE SOLUTION: Time Complexity: O(n+k), Space Complexity: O(k)
  public static void rotateArrayBruteForce(int[] arr, int k) {
    int n = arr.length;

    if (n == 0)
      return;
    if (k == 0)
      return;

    k = k % n; // Handle cases where k is greater than n
    int[] temp = new int[k];

    // Store the first k elements in a temporary array
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }

    // Shift the remaining elements to the left
    for (int i = k; i < n; i++) {
      arr[i - k] = arr[i];
    }

    // Copy the temporary array back to the end of the original array
    // int j = 0;
    // for (int i = n - k; i < n; i++) {
    // arr[i] = temp[j];
    // j++;
    // }
    for (int i = n - k; i < n; i++) {
      arr[i] = temp[i - (n - k)];
    }
  }

  // OPTIMAL SOLUTION: Time Complexity: O(n), Space Complexity: O(1)
  public static void rotateArray(int[] arr, int k) {
    int n = arr.length;

    if (n == 0)
      return;
    if (k == 0)
      return;

    k = k % n; // Handle cases where k is greater than n

    // Step 1: Reverse the first k elements
    reverse(arr, 0, k - 1);

    // Step 2: Reverse the remaining n-k elements
    reverse(arr, k, n - 1);

    // Step 3: Reverse the entire array
    reverse(arr, 0, n - 1);

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
