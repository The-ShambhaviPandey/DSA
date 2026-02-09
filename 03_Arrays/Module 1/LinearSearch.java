import java.util.Scanner;

public class LinearSearch {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter the target element to search:");
    int target = sc.nextInt();

    int index = linearSearch(arr, target);
    if (index != -1) {
      System.out.println("Element found at index: " + index);
    } else {
      System.out.println("Element not found in the array.");
    }

    sc.close();
  }

  /*
   * Linear Search Algorithm
   *
   * Idea:
   * - Traverse the array and compare each element with the target
   * - If a match is found, return the index
   * - If no match is found after traversing the entire array, return -1
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */

  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i; // return index of the target element
      }
    }
    return -1; // target element not found
  }

}
