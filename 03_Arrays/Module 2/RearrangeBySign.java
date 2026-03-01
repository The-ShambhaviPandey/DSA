import java.util.*;

public class RearrangeBySign {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the array elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    rearrange(arr);
    System.out.println("Rearranged array: " + Arrays.toString(arr));

    sc.close();
  }

  // Works even if positives and negatives are unequal
  public static void rearrange(int[] arr) {

    List<Integer> pos = new ArrayList<>();
    List<Integer> neg = new ArrayList<>();

    for (int num : arr) {
      if (num >= 0)
        pos.add(num);
      else
        neg.add(num);
    }

    int i = 0, p = 0, ng = 0;

    // Alternate as long as both have elements
    while (p < pos.size() && ng < neg.size()) {
      arr[i++] = pos.get(p++);
      arr[i++] = neg.get(ng++);
    }

    // Add remaining positives
    while (p < pos.size()) {
      arr[i++] = pos.get(p++);
    }

    // Add remaining negatives
    while (ng < neg.size()) {
      arr[i++] = neg.get(ng++);
    }
  }
}