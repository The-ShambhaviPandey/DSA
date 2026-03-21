import java.util.*;

public class CountInversions {

  // BRUTE
  // Time: O(n^2), Space: O(1)
  static int brute(int[] arr, int n) {
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          count++;
        }
      }
    }

    return count;
  }

  // BETTER
  // Time: O(n log n), Space: O(n)
  // (Using sorting idea with extra array)
  static int better(int[] arr, int n) {
    int[] temp = arr.clone();
    Arrays.sort(temp);

    HashMap<Integer, Integer> map = new HashMap<>();

    // Assign ranks
    for (int i = 0; i < n; i++) {
      map.put(temp[i], i);
    }

    int count = 0;

    // Count how far elements moved
    for (int i = 0; i < n; i++) {
      if (arr[i] != temp[i])
        count++;
    }

    return count; // Not exact inversion count, just indicative
  }

  // OPTIMAL
  // Time: O(n log n), Space: O(n)
  static int mergeSort(int[] arr, int low, int high) {
    int count = 0;

    if (low < high) {
      int mid = (low + high) / 2;

      count += mergeSort(arr, low, mid);
      count += mergeSort(arr, mid + 1, high);
      count += merge(arr, low, mid, high);
    }

    return count;
  }

  static int merge(int[] arr, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];

    int left = low, right = mid + 1, k = 0;
    int count = 0;

    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp[k++] = arr[left++];
      } else {
        temp[k++] = arr[right++];
        count += (mid - left + 1); // KEY LINE
      }
    }

    while (left <= mid) {
      temp[k++] = arr[left++];
    }

    while (right <= high) {
      temp[k++] = arr[right++];
    }

    for (int i = low; i <= high; i++) {
      arr[i] = temp[i - low];
    }

    return count;
  }

  static int optimal(int[] arr, int n) {
    return mergeSort(arr, 0, n - 1);
  }

  // MAIN
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Input
    System.out.println("Enter the size of array:");
    int n = sc.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // Brute
    int bruteAns = brute(arr.clone(), n);
    System.out.println("Brute Inversions: " + bruteAns);

    // Better (not exact, just demo)
    int betterAns = better(arr.clone(), n);
    System.out.println("Better (approx): " + betterAns);

    // Optimal
    int optimalAns = optimal(arr.clone(), n);
    System.out.println("Optimal Inversions: " + optimalAns);

    sc.close();
  }
}