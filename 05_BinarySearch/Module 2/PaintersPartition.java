import java.util.Scanner;

public class PaintersPartition {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(sum - max) * O(n), Space Complexity: O(1)

  public static int countPainters(int[] boards, int maxTime) {
    int painters = 1;
    int currentTime = 0;

    for (int i = 0; i < boards.length; i++) {

      if (currentTime + boards[i] <= maxTime) {
        currentTime += boards[i];
      } else {
        painters++;
        currentTime = boards[i];
      }

    }

    return painters;
  }

  public static int minTimeBrute(int[] boards, int k) {

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < boards.length; i++) {
      low = Math.max(low, boards[i]);
      high += boards[i];
    }

    for (int time = low; time <= high; time++) {
      if (countPainters(boards, time) <= k) {
        return time;
      }
    }

    return low;
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(n * log(sum-max)), Space Complexity: O(1)

  public static int minTimeOptimal(int[] boards, int k) {

    int low = Integer.MIN_VALUE;
    int high = 0;

    for (int i = 0; i < boards.length; i++) {
      low = Math.max(low, boards[i]);
      high += boards[i];
    }

    int ans = high;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (countPainters(boards, mid) <= k) {
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

    System.out.println("Enter number of boards:");
    int n = sc.nextInt();

    int[] boards = new int[n];

    System.out.println("Enter board lengths:");
    for (int i = 0; i < n; i++) {
      boards[i] = sc.nextInt();
    }

    System.out.println("Enter number of painters:");
    int k = sc.nextInt();

    sc.close();

    int brute = minTimeBrute(boards, k);
    System.out.println("Brute Result: " + brute);

    int optimal = minTimeOptimal(boards, k);
    System.out.println("Optimal Result: " + optimal);
  }
}