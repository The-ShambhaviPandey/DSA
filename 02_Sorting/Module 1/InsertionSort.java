import java.util.*;

public class InsertionSort {

  public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    System.out.println("Enter the number of elements:");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    insertionSort(arr);
    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    scanner.close();
  }
}
