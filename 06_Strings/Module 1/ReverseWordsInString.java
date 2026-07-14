import java.util.Scanner;

public class ReverseWordsInString {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static String reverseBrute(String s) {

    s = s.trim();

    String[] words = s.split("\\s+");

    StringBuilder ans = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {

      ans.append(words[i]);

      if (i != 0)
        ans.append(" ");
    }

    return ans.toString();
  }

  // BETTER APPROACH (USING STRINGBUILDER)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static String reverseBetter(String s) {

    s = s.trim();

    StringBuilder word = new StringBuilder();
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {

      char ch = s.charAt(i);

      if (ch != ' ') {

        word.append(ch);

      } else {

        if (word.length() > 0) {

          if (ans.length() == 0)
            ans.insert(0, word.toString());
          else
            ans.insert(0, word.toString() + " ");

          word.setLength(0);
        }
      }
    }

    if (word.length() > 0) {

      if (ans.length() == 0)
        ans.insert(0, word.toString());
      else
        ans.insert(0, word.toString() + " ");
    }

    return ans.toString().trim();
  }

  // OPTIMAL APPROACH (TRAVERSE FROM END)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static String reverseOptimal(String s) {

    s = s.trim();

    StringBuilder ans = new StringBuilder();

    int i = s.length() - 1;

    while (i >= 0) {

      while (i >= 0 && s.charAt(i) == ' ')
        i--;

      if (i < 0)
        break;

      int j = i;

      while (j >= 0 && s.charAt(j) != ' ')
        j--;

      ans.append(s.substring(j + 1, i + 1));

      ans.append(" ");

      i = j;
    }

    return ans.toString().trim();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a string:");

    String s = sc.nextLine();

    sc.close();

    String brute = reverseBrute(s);
    System.out.println("Brute Result: " + brute);

    String better = reverseBetter(s);
    System.out.println("Better Result: " + better);

    String optimal = reverseOptimal(s);
    System.out.println("Optimal Result: " + optimal);
  }
}