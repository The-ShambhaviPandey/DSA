import java.util.Scanner;

public class FloorAndCeil {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n), Space Complexity: O(1)

  public static int[] floorCeilBrute(int[] arr, int x) {
    int floor = -1, ceil = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] <= x) {
        floor = arr[i];
      }
      if (arr[i] >= x) {
        ceil = arr[i];
        break;
      }
    }

    return new int[] { floor, ceil };
  }

  // OPTIMAL APPROACH (BINARY SEARCH)
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int[] floorCeilOptimal(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int floor = -1, ceil = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == x) {
        return new int[] { arr[mid], arr[mid] };
      }

      if (arr[mid] < x) {
        floor = arr[mid];
        low = mid + 1;
      } else {
        ceil = arr[mid];
        high = mid - 1;
      }
    }

    return new int[] { floor, ceil };
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

    int[] brute = floorCeilBrute(arr, x);
    System.out.println("Brute Floor: " + brute[0] + ", Ceil: " + brute[1]);

    int[] optimal = floorCeilOptimal(arr, x);
    System.out.println("Optimal Floor: " + optimal[0] + ", Ceil: " + optimal[1]);
  }
}