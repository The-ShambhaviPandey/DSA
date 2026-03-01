import java.util.*;

public class LongestConsecutiveSeq {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int longestSeqLength = findLongestConsecutiveSequence(arr);
    System.out.println("The length of the longest consecutive sequence is: " + longestSeqLength);
    sc.close();
  }

  // Brute Force Approach
  public static int findLongestConsecutiveSequenceBrute(int[] arr) {
    int n = arr.length;
    int longestLength = 1;

    for (int i = 0; i < n; i++) {
      int currentLength = 1;
      for (int j = 0; j < n; j++) {
        if (arr[j] == arr[i] + currentLength) {
          currentLength++;
        }
      }
      longestLength = Math.max(longestLength, currentLength);
    }
    return longestLength;
  }

  // Better Approach
  public static int findLongestConsecutiveSequenceBetter(int[] arr) {
    Arrays.sort(arr);
    int longestLength = 1;
    int currentLength = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        continue; // Skip duplicates
      } else if (arr[i] == arr[i - 1] + 1) {
        currentLength++;
      } else {
        longestLength = Math.max(longestLength, currentLength);
        currentLength = 1;
      }
    }
    return Math.max(longestLength, currentLength);
  }

  // Optimal Approach
  public static int findLongestConsecutiveSequence(int[] arr) {

    if (arr.length == 0)
      return 0;

    Set<Integer> numSet = new HashSet<>();
    for (int num : arr) {
      numSet.add(num);
    }

    int longestLength = 0;

    for (int num : numSet) {

      if (!numSet.contains(num - 1)) {

        int currentNum = num;
        int currentLength = 1;

        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentLength++;
        }

        longestLength = Math.max(longestLength, currentLength);
      }
    }

    return longestLength;
  }

}
