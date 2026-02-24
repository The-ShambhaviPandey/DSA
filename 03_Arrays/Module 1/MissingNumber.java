import java.util.Scanner;

public class MissingNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter n (numbers from 1 to n): ");
    int n = sc.nextInt();

    int[] arr = new int[n - 1];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n - 1; i++) {
      arr[i] = sc.nextInt();
    }

    int missingNumber = findMissingNumberXOR(arr, n);
    System.out.println("The missing number is: " + missingNumber);

    sc.close();
  }

  // Naive Approach: Brute Force
  // Time: O(n^2), Space: O(1)
  public static int findMissingNumberBruteForce(int[] arr, int n) {
    for (int i = 1; i <= n; i++) {
      boolean found = false;
      for (int num : arr) {
        if (num == i) {
          found = true;
          break;
        }
      }
      if (!found) {
        return i;
      }
    }
    return -1; // Should never occur if input is valid
  }

  // Better Approach: Hashing
  // Time: O(n), Space: O(n)
  public static int findMissingNumberHashing(int[] arr, int n) {

    int[] hash = new int[n + 1];

    for (int num : arr) {
      hash[num]++;
    }

    for (int i = 1; i <= n; i++) {
      if (hash[i] == 0) {
        return i;
      }
    }

    return -1; // Should never occur if input is valid
  }

  // Optimal Approach: Mathematical Formula
  // Time: O(n), Space: O(1)
  public static int findMissingNumberMath(int[] arr, int n) {

    long totalSum = (long) n * (n + 1) / 2; // Prevent overflow
    long arraySum = 0;

    for (int num : arr) {
      arraySum += num;
    }

    return (int) (totalSum - arraySum);
  }

  // Optimal Approach: XOR (Best Choice)
  // Time: O(n), Space: O(1)
  public static int findMissingNumberXOR(int[] arr, int n) {

    int xorAll = 0;
    int xorArray = 0;

    for (int i = 1; i <= n; i++) {
      xorAll ^= i;
    }

    for (int num : arr) {
      xorArray ^= num;
    }

    return xorAll ^ xorArray;
  }
}