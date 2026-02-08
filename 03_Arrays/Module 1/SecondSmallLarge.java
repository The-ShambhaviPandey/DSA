import java.util.Scanner;

public class SecondSmallLarge {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // Brute force approach: O(n log n) due to sorting
    // Arrays.sort(arr);
    // System.out.println("Second smallest element: " + arr[1]);
    // System.out.println("Second largest element: " + arr[n - 2]);
    // sc.close();

    // Better approach: O(n) without sorting, but requires two passes
    /*
     * int smallest = Integer.MAX_VALUE;
     * int largest = Integer.MIN_VALUE;
     * for (int i = 0; i < n; i++) {
     * if (arr[i] < smallest) {
     * smallest = arr[i];
     * }
     * if (arr[i] > largest) {
     * largest = arr[i];
     * }
     * }
     * 
     * int secondSmallest = Integer.MAX_VALUE;
     * int secondLargest = Integer.MIN_VALUE;
     * for (int i = 0; i < n; i++) {
     * if (arr[i] < secondSmallest && arr[i] != smallest) {
     * secondSmallest = arr[i];
     * }
     * if (arr[i] > secondLargest && arr[i] != largest) {
     * secondLargest = arr[i];
     * }
     */

    // Optimal approach: O(n) without sorting
    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (arr[i] < smallest) {
        secondSmallest = smallest;
        smallest = arr[i];
      } else if (arr[i] < secondSmallest && arr[i] != smallest) {
        secondSmallest = arr[i];
      }

      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] > secondLargest && arr[i] != largest) {
        secondLargest = arr[i];
      }
    }

    System.out.println("Second smallest element: " + secondSmallest);
    System.out.println("Second largest element: " + secondLargest);
    sc.close();

  }

}
