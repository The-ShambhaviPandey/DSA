import java.util.*;

public class SingleNumberOne {

  public static int findSingle(int[] arr) {
    int xor = 0;

    for (int num : arr) {
      xor ^= num;
    }

    return xor;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int result = findSingle(arr);

    System.out.println("The single element is: " + result);

    sc.close();
  }
}