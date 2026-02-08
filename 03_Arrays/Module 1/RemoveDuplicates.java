import java.util.*;

public class RemoveDuplicates {

  public static void main(String[] args) {

    // Brute Force Approach-> sort the array and remove duplicates-> O(nlogn)
    /*
     * Optimal Approach-> Traverse array and keep track of the unique elements->
     * O(n)-> but we need extra space for set
     */

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of array");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(arr[i]);
    }

    System.out.println("The unique elements are: " + set);
    sc.close();
  }

  /*
   * If the array is sorted, brute force approach is optimal for both time and
   * space.
   */

}
