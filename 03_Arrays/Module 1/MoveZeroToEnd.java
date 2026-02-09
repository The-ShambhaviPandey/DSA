import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroToEnd {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Choose approach:");
    System.out.println("1 -> Brute Force");
    System.out.println("2 -> Optimal");
    int choice = sc.nextInt();

    if (choice == 1) {
      moveZeroToEndBrute(arr);
      System.out.println("Using Brute Force approach");
    } else if (choice == 2) {
      moveZeroToEndOptimal(arr);
      System.out.println("Using Optimal approach");
    } else {
      System.out.println("Invalid choice");
      sc.close();
      return;
    }

    System.out.println("Array after moving zeros to the end:");
    System.out.println(Arrays.toString(arr));

    sc.close();
  }

  /*
   * Brute Force Approach
   *
   * Idea:
   * - Copy all non-zero elements to the front
   * - Fill remaining positions with zero
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void moveZeroToEndBrute(int[] arr) {

    int count = 0; // index for non-zero elements

    // move non-zero elements to the front
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[count++] = arr[i];
      }
    }

    // fill remaining positions with zero
    while (count < arr.length) {
      arr[count++] = 0;
    }
  }

  /*
   * Optimal Approach (Two Pointer / Swap-based)
   *
   * Idea:
   * - Maintain a pointer `count` for the next non-zero position
   * - Swap current non-zero element with element at `count`
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void moveZeroToEndOptimal(int[] arr) {

    int count = 0; // index of where next non-zero should go

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        int temp = arr[count];
        arr[count] = arr[i];
        arr[i] = temp;
        count++;
      }
    }
  }
}
