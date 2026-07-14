import java.util.Scanner;

public class RemoveOutermostParentheses {

  public static String removeOuter(String s) {

    StringBuilder ans = new StringBuilder();

    int start = 0;
    int balance = 0;

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == '(')
        balance++;
      else
        balance--;

      // Primitive completed
      if (balance == 0) {

        // Skip first and last bracket
        for (int j = start + 1; j < i; j++) {
          ans.append(s.charAt(j));
        }

        start = i + 1;
      }
    }

    return ans.toString();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the parentheses string:");
    String s = sc.nextLine();

    sc.close();

    String ans = removeOuter(s);
    System.out.println("Result: " + ans);
  }
}