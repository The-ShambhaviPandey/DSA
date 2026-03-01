import java.util.*;

public class SortThreeColors {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array:");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array (0, 1, or 2):");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    sortColors(arr);
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    sc.close();
  }

  // Brute Force Approach
  public static void sortColorsBrute(int[] arr) {
    int n = arr.length;
    int count0 = 0, count1 = 0, count2 = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        count0++;
      } else if (arr[i] == 1) {
        count1++;
      } else {
        count2++;
      }
    }

    int index = 0;
    while (count0 > 0) {
      arr[index++] = 0;
      count0--;
    }
    while (count1 > 0) {
      arr[index++] = 1;
      count1--;
    }
    while (count2 > 0) {
      arr[index++] = 2;
      count2--;
    }
  }

  // Better Approach:Using HashMap
  public static void sortColorsBetter(int[] arr) {

    int n = arr.length;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    int index = 0;
    for (int key : map.keySet()) {
      int count = map.get(key);
      while (count > 0) {
        arr[index++] = key;
        count--;
      }
    }
  }

  // Optimal Approach: Using Dutch National Flag Algorithm
  public static void sortColors(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    while (mid <= high) {
      if (arr[mid] == 0) {
        swap(arr, low, mid);
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, high);
        high--;
      }
    }
  }

  // Helper function to swap elements in the array
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
