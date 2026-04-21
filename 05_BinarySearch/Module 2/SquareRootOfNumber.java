import java.util.Scanner;

public class SquareRootOfNumber {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(sqrt(n)), Space Complexity: O(1)

  public static int squareRootBrute(int n) {
    int ans = 1;

    while ((long) ans * ans <= n) {
      ans++;
    }

    return ans - 1;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int squareRootOptimal(int n) {
    int low = 1, high = n;
    int ans = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      long square = (long) mid * mid;

      if (square == n) {
        return mid;
      } else if (square < n) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number:");
    int n = sc.nextInt();

    sc.close();

    int brute = squareRootBrute(n);
    System.out.println("Brute Result: " + brute);

    int optimal = squareRootOptimal(n);
    System.out.println("Optimal Result: " + optimal);
  }
}