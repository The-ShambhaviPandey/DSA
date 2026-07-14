import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n * m)
  // Space Complexity: O(1)

  public static String longestCommonPrefixBrute(String[] strs) {

    if (strs.length == 0)
      return "";

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {

      while (!strs[i].startsWith(prefix)) {

        prefix = prefix.substring(0, prefix.length() - 1);

        if (prefix.isEmpty())
          return "";
      }
    }

    return prefix;
  }

  // BETTER APPROACH (SORTING)
  // Time Complexity: O(n log n + m)
  // Space Complexity: O(1)

  public static String longestCommonPrefixBetter(String[] strs) {

    Arrays.sort(strs);

    String first = strs[0];
    String last = strs[strs.length - 1];

    int i = 0;

    while (i < first.length() &&
        i < last.length() &&
        first.charAt(i) == last.charAt(i)) {

      i++;
    }

    return first.substring(0, i);
  }

  // OPTIMAL APPROACH (CHARACTER BY CHARACTER)
  // Time Complexity: O(n * m)
  // Space Complexity: O(1)

  public static String longestCommonPrefixOptimal(String[] strs) {

    if (strs.length == 0)
      return "";

    for (int i = 0; i < strs[0].length(); i++) {

      char ch = strs[0].charAt(i);

      for (int j = 1; j < strs.length; j++) {

        if (i >= strs[j].length() || strs[j].charAt(i) != ch) {

          return strs[0].substring(0, i);
        }
      }
    }

    return strs[0];
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of strings:");

    int n = sc.nextInt();
    sc.nextLine();

    String[] strs = new String[n];

    System.out.println("Enter strings:");

    for (int i = 0; i < n; i++) {
      strs[i] = sc.nextLine();
    }

    sc.close();

    String brute = longestCommonPrefixBrute(strs.clone());
    System.out.println("Brute Result: " + brute);

    String better = longestCommonPrefixBetter(strs.clone());
    System.out.println("Better Result: " + better);

    String optimal = longestCommonPrefixOptimal(strs.clone());
    System.out.println("Optimal Result: " + optimal);
  }
}