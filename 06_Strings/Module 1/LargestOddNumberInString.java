import java.util.Scanner;

public class LargestOddNumberInString {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n²)
  // Space Complexity: O(1)

  public static String largestOddBrute(String s) {

    String ans = "";

    for (int i = 0; i < s.length(); i++) {

      String temp = s.substring(0, i + 1);

      char last = temp.charAt(temp.length() - 1);

      if ((last - '0') % 2 != 0) {
        ans = temp;
      }
    }

    return ans;
  }

  // OPTIMAL APPROACH
  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static String largestOddOptimal(String s) {

    for (int i = s.length() - 1; i >= 0; i--) {

      int digit = s.charAt(i) - '0';

      if (digit % 2 != 0) {
        return s.substring(0, i + 1);
      }
    }

    return "";
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a numeric string:");

    String s = sc.nextLine();

    sc.close();

    String brute = largestOddBrute(s);
    System.out.println("Brute Result: " + brute);

    String optimal = largestOddOptimal(s);
    System.out.println("Optimal Result: " + optimal);
  }
}