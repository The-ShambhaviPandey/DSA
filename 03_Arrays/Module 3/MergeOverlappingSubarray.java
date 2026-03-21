import java.util.*;

public class MergeOverlappingSubarray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Input
    int n = sc.nextInt();
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
    }

    // Choose method: brute / better / optimal
    List<int[]> res = optimal(arr);

    // Output
    for (int[] interval : res) {
      System.out.println(interval[0] + " " + interval[1]);
    }

    sc.close();
  }

  // BRUTE
  // Time: O(n^2), Space: O(n)
  static List<int[]> brute(int[][] arr) {
    int n = arr.length;
    boolean[] visited = new boolean[n];
    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (visited[i])
        continue;

      int start = arr[i][0];
      int end = arr[i][1];

      for (int j = i + 1; j < n; j++) {
        if (visited[j])
          continue;

        // Check overlap
        if (!(arr[j][1] < start || arr[j][0] > end)) {
          start = Math.min(start, arr[j][0]);
          end = Math.max(end, arr[j][1]);
          visited[j] = true;
        }
      }

      res.add(new int[] { start, end });
    }

    return res;
  }

  // BETTER
  // Time: O(n log n + n^2), Space: O(n)
  static List<int[]> better(int[][] arr) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      int start = arr[i][0];
      int end = arr[i][1];

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j][0] <= end) {
          end = Math.max(end, arr[j][1]);
        } else {
          break;
        }
      }

      res.add(new int[] { start, end });
    }

    return res;
  }

  // OPTIMAL
  // Time: O(n log n), Space: O(n)
  static List<int[]> optimal(int[][] arr) {
    Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> res = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (res.isEmpty() || res.get(res.size() - 1)[1] < arr[i][0]) {
        res.add(new int[] { arr[i][0], arr[i][1] });
      } else {
        res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], arr[i][1]);
      }
    }

    return res;
  }
}