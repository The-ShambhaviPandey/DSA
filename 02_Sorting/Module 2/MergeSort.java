import java.util.*;

public class MergeSort {

  public static void mergeSort(int[] array) {
    if (array.length < 2) {
      return; // Array is already sorted
    }
    int mid = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);

    mergeSort(left);
    mergeSort(right);
    merge(array, left, right);
  }

  public static void merge(int[] array, int[] left, int[] right) {
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }
    while (i < left.length) {
      array[k++] = left[i++];
    }
    while (j < right.length) {
      array[k++] = right[j++];
    }
  }

  public static void main(String[] args) {
    System.out.println("Enter size of array:");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    mergeSort(arr);
    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    scanner.close();
  }
}