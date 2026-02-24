import java.util.*;

public class MaxConsecutiveOnes {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter the elements of the array (0s and 1s):");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int maxConsecutiveOnes = findMaxConsecutiveOnes(arr);
    System.out.println("The maximum number of consecutive 1s is: " + maxConsecutiveOnes);

    sc.close();
  }

  public static int findMaxConsecutiveOnes(int[] arr) {

    int maxCount = 0;
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        count++;
      } else {
        maxCount = Math.max(maxCount, count);
        count = 0;
      }
    }

    // Final check in case array ends with 1s
    maxCount = Math.max(maxCount, count);

    return maxCount;
  }
}

// Time Complexity: O(n) - We traverse the array once.
// Space Complexity: O(1) - We use only a constant amount of extra space.