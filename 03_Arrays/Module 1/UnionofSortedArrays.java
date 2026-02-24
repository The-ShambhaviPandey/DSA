import java.util.*;

public class UnionofSortedArrays {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the both arrays:");
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr1 = new int[n];
    int[] arr2 = new int[m];
    System.out.println("Enter the elements of the first array:");
    for (int i = 0; i < n; i++) {
      arr1[i] = sc.nextInt();
    }
    System.out.println("Enter the elements of the second array:");
    for (int i = 0; i < m; i++) {
      arr2[i] = sc.nextInt();
    }
    int[] union = unionOfSortedArrays(arr1, arr2);
    for (int i = 0; i < union.length; i++) {
      System.out.print(union[i] + " ");
    }

    sc.close();
  }

  // Brute Force Approach - Using Map
  public static int[] unionOfSortedArraysBrute(int[] arr1, int[] arr2) {
    Set<Integer> set = new HashSet<>();
    for (int num : arr1) {
      set.add(num);
    }
    for (int num : arr2) {
      set.add(num);
    }
    int[] union = new int[set.size()];
    int index = 0;
    for (int num : set) {
      union[index++] = num;
    }
    Arrays.sort(union); // Sort the union array
    return union;
  }

  // Better Approach - Using Set
  public static int[] unionOfSortedArraysBetter(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    int[] union = new int[n + m];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      if (arr1[i] < arr2[j]) {
        if (k == 0 || union[k - 1] != arr1[i]) {
          union[k++] = arr1[i];
        }
        i++;
      } else if (arr1[i] > arr2[j]) {
        if (k == 0 || union[k - 1] != arr2[j]) {
          union[k++] = arr2[j];
        }
        j++;
      } else {
        if (k == 0 || union[k - 1] != arr1[i]) {
          union[k++] = arr1[i];
        }
        i++;
        j++;
      }
    }

    while (i < n) {
      if (k == 0 || union[k - 1] != arr1[i]) {
        union[k++] = arr1[i];
      }
      i++;
    }

    while (j < m) {
      if (k == 0 || union[k - 1] != arr2[j]) {
        union[k++] = arr2[j];
      }
      j++;
    }

    return Arrays.copyOf(union, k); // Return only the filled portion of the array
  }

  // Optimal Approach - Using Two Pointers
  public static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    int[] union = new int[n + m];
    int i = 0, j = 0, k = 0;
    while (i < n && j < m) {
      if (arr1[i] < arr2[j]) {
        union[k++] = arr1[i++];
      } else if (arr1[i] > arr2[j]) {
        union[k++] = arr2[j++];
      } else {
        union[k++] = arr1[i];
        i++;
        j++;
      }
    }
    while (i < n) {
      union[k++] = arr1[i++];
    }
    while (j < m) {
      union[k++] = arr2[j++];
    }
    return Arrays.copyOf(union, k); // Return only the filled portion of the array
  }

}
