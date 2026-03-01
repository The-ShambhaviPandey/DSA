import java.util.*;

public class LeadersArray {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("The leaders in the array are: ");
    findLeaders(arr);
    sc.close();
  }

  // Brute Force Approach
  public static void findLeadersBrute(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      boolean isLeader = true;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] < arr[j]) {
          isLeader = false;
          break;
        }
      }
      if (isLeader) {
        System.out.print(arr[i] + " ");
      }
    }
  }

  // Optimal Approach
  public static void findLeaders(int[] arr) {

    int n = arr.length;
    List<Integer> leaders = new ArrayList<>();

    int maxFromRight = arr[n - 1];
    leaders.add(maxFromRight);

    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] > maxFromRight) {
        maxFromRight = arr[i];
        leaders.add(maxFromRight);
      }
    }

    // Reverse to maintain original order
    Collections.reverse(leaders);

    for (int num : leaders) {
      System.out.print(num + " ");
    }
  }
}
