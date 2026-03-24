import java.util.*;

public class SubsetsBitwise {

  public static void printSubsets(int[] arr) {
    int n = arr.length;
    int total = 1 << n; // 2^n

    for (int i = 0; i < total; i++) {
      System.out.print("{ ");

      for (int j = 0; j < n; j++) {
        // check if jth bit is set
        if ((i & (1 << j)) != 0) {
          System.out.print(arr[j] + " ");
        }
      }

      System.out.println("}");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Subsets:");
    printSubsets(arr);

    sc.close();
  }
}