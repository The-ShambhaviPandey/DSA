import java.util.*;

public class NumberAppearOnce {

  public static void main(String args[]) {

    System.out.println("Enter the size of the array: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int result = findAppearanceofNumberOnce(arr);
    System.out.println("The number that appears only once is: " + result);

    sc.close();
  }

  public static int findAppearanceofNumberOnce(int[] arr) {

    // Optimal Approach: XOR
    // Time: O(n)
    // Space: O(1)

    int xor = 0;

    for (int num : arr) {
      xor ^= num;
    }

    return xor;
  }

  // Brute Force Approach
  // Time: O(n^2), Space: O(1)
  public static int bruteForce(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      int count = 0;

      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }

      if (count == 1) {
        return arr[i];
      }
    }

    return -1;
  }

  // Better Approach: Hashing
  // Time: O(n), Space: O(n)
  public static int hashing(int[] arr) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : arr) {
      if (map.get(num) == 1) {
        return num;
      }
    }

    return -1;
  }
}