import java.util.*;

public class ReversePairs {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Reverse pairs: " + reversePairsOptimal(arr));

    sc.close();
  }

  // BRUTE FORCE
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)

  public static int reversePairsBrute(int[] arr) {

    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {

        if (arr[i] > 2 * arr[j]) {
          count++;
        }
      }
    }

    return count;
  }

  // OPTIMAL APPROACH (Merge Sort)
  // Time Complexity: O(n log n)
  // Space Complexity: O(n)

  public static int reversePairsOptimal(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  public static int mergeSort(int[] arr, int low, int high) {

    if (low >= high)
      return 0;

    int mid = (low + high) / 2;

    int count = 0;

    count += mergeSort(arr, low, mid);
    count += mergeSort(arr, mid + 1, high);

    count += countPairs(arr, low, mid, high);

    merge(arr, low, mid, high);

    return count;
  }

  public static int countPairs(int[] arr, int low, int mid, int high) {

    int right = mid + 1;
    int count = 0;

    for (int i = low; i <= mid; i++) {

      while (right <= high && arr[i] > 2L * arr[right]) {
        right++;
      }

      count += right - (mid + 1);
    }

    return count;
  }

  public static void merge(int[] arr, int low, int mid, int high) {

    List<Integer> temp = new ArrayList<>();

    int left = low;
    int right = mid + 1;

    while (left <= mid && right <= high) {

      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        right++;
      }
    }

    while (left <= mid) {
      temp.add(arr[left++]);
    }

    while (right <= high) {
      temp.add(arr[right++]);
    }

    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
  }
}