import java.util.*;

public class CountSubarrayXORK {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter value of k:");
    int k = sc.nextInt();

    System.out.println("Number of subarrays: " + subarrayXorOptimal(arr, k));

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)

  public static int subarrayXorBrute(int[] arr, int k) {

    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {

      int xor = 0;

      for (int j = i; j < n; j++) {

        xor ^= arr[j];

        if (xor == k) {
          count++;
        }
      }
    }

    return count;
  }

  // OPTIMAL APPROACH (Prefix XOR + HashMap)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static int subarrayXorOptimal(int[] arr, int k) {

    int n = arr.length;

    HashMap<Integer, Integer> map = new HashMap<>();

    int xor = 0;
    int count = 0;

    map.put(0, 1); // important for cases starting at index 0

    for (int i = 0; i < n; i++) {

      xor ^= arr[i];

      int x = xor ^ k;

      if (map.containsKey(x)) {
        count += map.get(x);
      }

      map.put(xor, map.getOrDefault(xor, 0) + 1);
    }

    return count;
  }
}