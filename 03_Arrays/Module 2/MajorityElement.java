import java.util.*;

public class MajorityElement {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int majorityElement = findMajorityElement(arr);
    System.out.println("The majority element is: " + majorityElement);

    sc.close();
  }

  // Brute Force Approach
  public static int findMajorityElementBrute(int[] arr) {

    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int count = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }
      if (count > n / 2) {
        return arr[i];
      }
    }
    return -1; // No majority element found
  }

  // Better Approach using HashMap
  public static int findMajorityElementHashMap(int[] arr) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    int n = arr.length;

    for (int num : arr) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() > n / 2) {
        return entry.getKey();
      }
    }
    return -1; // No majority element found
  }

  // Optimal Approach using Boyer-Moore Voting Algorithm
  public static int findMajorityElement(int[] arr) {
    int count = 0;
    Integer candidate = null;
    for (int num : arr) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }
    return candidate;
  }

}
