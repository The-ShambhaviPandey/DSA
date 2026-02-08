import java.util.Scanner;

public class CheckSorted {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(isSorted(arr));
    sc.close();
  }

  // Brute Force Approach-> run two loops to compare current and previous-> O(n^2)
  // Optimal Approach-> run a single loop to compare current and previous-> O(n)
  public static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

}
