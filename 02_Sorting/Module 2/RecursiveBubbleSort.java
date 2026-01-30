import java.util.*;

public class RecursiveBubbleSort {

  public static void recursiveBubbleSort(int[] array, int n) {
    if (n == 1) {
      return;
    }
    for (int i = 0; i < n - 1; i++) {
      if (array[i] > array[i + 1]) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
      }
    }
    recursiveBubbleSort(array, n - 1);
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
    recursiveBubbleSort(arr, n);
    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    scanner.close();
  }
}
