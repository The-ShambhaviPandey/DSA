import java.util.Scanner;

public class NthRoot {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(M), Space Complexity: O(1)

  public static int nthRootBrute(int n, int m) {
    for (int i = 1; i <= m; i++) {
      long value = 1;

      for (int j = 1; j <= n; j++) {
        value *= i;

        if (value > m) {
          break;
        }
      }

      if (value == m) {
        return i;
      }
    }

    return -1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log M * N), Space Complexity: O(1)

  public static int nthRootOptimal(int n, int m) {
    int low = 1, high = m;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      long value = 1;
      for (int i = 1; i <= n; i++) {
        value *= mid;

        if (value > m) {
          break;
        }
      }

      if (value == m) {
        return mid;
      } else if (value < m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter N:");
    int n = sc.nextInt();

    System.out.println("Enter M:");
    int m = sc.nextInt();

    sc.close();

    int brute = nthRootBrute(n, m);
    System.out.println("Brute Result: " + brute);

    int optimal = nthRootOptimal(n, m);
    System.out.println("Optimal Result: " + optimal);
  }
}