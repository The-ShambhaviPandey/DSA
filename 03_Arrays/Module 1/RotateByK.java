import java.util.Arrays;
import java.util.Scanner;

public class RotateByK {

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
    System.out.println("Array after rotation: " + Arrays.toString(arr));
  }

  // BRUTE FORCE SOLUTION: Time Complexity: O(n*k), Space Complexity: O(1)
  public static void rotateArrayBruteForce(int[] arr, int k) {
    int n = arr.length;
    k = k % n; // Handle cases where k is greater than n
    for (int i = 0; i < k; i++) {
      int last = arr[n - 1]; // Store the last element
      // Shift all elements to the right
      for (int j = n - 1; j > 0; j--) {
        arr[j] = arr[j - 1];
      }
      arr[0] = last; // Place the last element at the front
    }
  }

  // OPTIMAL SOLUTION: Time Complexity: O(n), Space Complexity: O(1)
  public static void rotateArray(int[] arr, int k) {
    int n = arr.length;
    k = k % n; // Handle cases where k is greater than n
    reverse(arr, 0, n - 1); // Reverse the entire array
    reverse(arr, 0, k - 1); // Reverse the first k elements
    reverse(arr, k, n - 1); // Reverse the remaining elements
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
