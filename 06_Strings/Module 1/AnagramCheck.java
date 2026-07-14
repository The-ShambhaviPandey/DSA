import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

  // BRUTE FORCE APPROACH (SORTING)
  // Time Complexity: O(n log n)
  // Space Complexity: O(n)

  public static boolean checkAnagramBrute(String str1, String str2) {

    if (str1.length() != str2.length())
      return false;

    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    return Arrays.equals(arr1, arr2);
  }

  // OPTIMAL APPROACH (FREQUENCY ARRAY)
  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static boolean checkAnagramOptimal(String str1, String str2) {

    if (str1.length() != str2.length())
      return false;

    int[] freq = new int[26];

    for (int i = 0; i < str1.length(); i++) {

      freq[str1.charAt(i) - 'a']++;

      freq[str2.charAt(i) - 'a']--;
    }

    for (int count : freq) {

      if (count != 0)
        return false;
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter first string:");
    String str1 = sc.nextLine().toLowerCase();

    System.out.println("Enter second string:");
    String str2 = sc.nextLine().toLowerCase();

    sc.close();

    boolean brute = checkAnagramBrute(str1, str2);
    System.out.println("Brute Result: " + brute);

    boolean optimal = checkAnagramOptimal(str1, str2);
    System.out.println("Optimal Result: " + optimal);
  }
}