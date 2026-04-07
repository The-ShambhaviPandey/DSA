import java.util.Scanner;

public class LowerBound {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int lowerBoundBrute(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= x) {
        return i;
      }
    }
    return arr.length;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int lowerBoundOptimal(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = arr.length;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] >= x) {
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

    System.out.println("Enter Array size:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter Array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter target value:");
    int x = sc.nextInt();

    sc.close();

    int brute = lowerBoundBrute(arr, x);
    System.out.println("Brute Result: " + brute);

    int optimal = lowerBoundOptimal(arr, x);
    System.out.println("Optimal Result: " + optimal);
  }
}