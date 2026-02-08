import java.util.*;

public class LargestElement {

  public static void main(String[] args) {

    // Brute Force Approach-> sort the array and return the last element-> O(nlogn)
    // Optimal Approach-> Traverse array and keep track of the maximum element->
    // O(n)

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of array");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    System.out.println("The largest element is: " + max);
    sc.close();
  }
}