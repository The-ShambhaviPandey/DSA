import java.util.Arrays;
import java.util.Scanner;

public class RightRotateByOne {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    sc.close();

    rightRotateByOne(arr);

    System.out.println("Array after right rotation by one:");
    System.out.println(Arrays.toString(arr));
  }

  public static void rightRotateByOne(int[] arr) {

    if (arr.length == 0)
      return;

    int lastElement = arr[arr.length - 1];
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = lastElement;
  }

  /*
   * Time Complexity: O(n) - We need to traverse the array once to perform the
   * right rotation.
   * Space Complexity: O(1) - We are using only a constant amount of extra space
   * to store the last element and perform the rotation in place.
   */

}
