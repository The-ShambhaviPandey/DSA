import java.util.Scanner;

public class BinarySearch {

  // ITERATIVE APPROACH
  // Time Complexity: O(log n), Space Complexity: O(1)

  public static int binarySearchIterative(int[] arr, int target) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  // RECURSIVE APPROACH
  // Time Complexity: O(log n),Space Complexity: O(log n)
  public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
    if (low > high) {
      return -1;
    }

    int mid = low + (high - low) / 2;

    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] < target) {
      return binarySearchRecursive(arr, mid + 1, high, target);
    } else {
      return binarySearchRecursive(arr, low, mid - 1, target);
    }
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
    int target = sc.nextInt();

    sc.close();

    int resultIter = binarySearchIterative(arr, target);
    System.out.println("Iterative Result: " + resultIter);

    int resultRec = binarySearchRecursive(arr, 0, arr.length - 1, target);
    System.out.println("Recursive Result: " + resultRec);
  }
}