import java.util.Scanner;

public class LeftRotateByOne {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    leftRotateByOne(arr);
    System.out.println("Array after left rotation by one:");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    sc.close();
  }

  /*
   * Brute Force Approach-> create a new array and copy elements from the original
   * array to the new array in the rotated order. This approach has a time
   * complexity of O(n) and space complexity of O(n).
   * 
   * Optimal Approach-> Use a temporary variable to store the first element of the
   * array, then shift all elements to the left by one position, and finally place
   * the stored element at the end of the array. This approach has a time
   * complexity of O(n) and space complexity of O(1).
   */

  public static void leftRotateByOne(int[] arr) {
    if (arr.length == 0)
      return;
    int temp = arr[0];
    for (int i = 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }
    arr[arr.length - 1] = temp;
  }

}
