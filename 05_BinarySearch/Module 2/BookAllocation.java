import java.util.Scanner;

public class BookAllocation {

  // BRUTE FORCE APPROACH
  // Time Complexity: O((sum-max) * n), Space Complexity: O(1)

  public static int countStudents(int[] arr, int pages) {
    int students = 1;
    int pagesStudent = 0;

    for (int i = 0; i < arr.length; i++) {

      if (pagesStudent + arr[i] <= pages) {
        pagesStudent += arr[i];
      } else {
        students++;
        pagesStudent = arr[i];
      }

    }

    return students;
  }

  public static int findPagesBrute(int[] arr, int m) {

    int n = arr.length;

    if (m > n) {
      return -1;
    }

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < n; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }

    for (int pages = low; pages <= high; pages++) {
      if (countStudents(arr, pages) <= m) {
        return pages;
      }
    }

    return low;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(n * log(sum-max)), Space Complexity: O(1)

  public static int findPagesOptimal(int[] arr, int m) {

    int n = arr.length;

    if (m > n) {
      return -1;
    }

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < n; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }

    int ans = high;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (countStudents(arr, mid) <= m) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of books:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter pages in books:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter number of students:");
    int m = sc.nextInt();

    sc.close();

    int brute = findPagesBrute(arr, m);
    System.out.println("Brute Result: " + brute);

    int optimal = findPagesOptimal(arr, m);
    System.out.println("Optimal Result: " + optimal);
  }
}