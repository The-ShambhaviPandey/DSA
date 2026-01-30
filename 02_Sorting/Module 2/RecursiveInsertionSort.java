import java.util.*;

public class RecursiveInsertionSort {

  public static void main(String[] args) {
    System.out.println("Enter size of array:");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    recursiveInsertionSort(arr, n);
    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    scanner.close();
  }

  public static void recursiveInsertionSort(int[] array, int n) {
    if (n <= 1) {
      return;
    }
    recursiveInsertionSort(array, n - 1);
    int last = array[n - 1];
    int j = n - 2;
    while (j >= 0 && array[j] > last) {
      array[j + 1] = array[j];
      j--;
    }
    array[j + 1] = last;
  }
}
