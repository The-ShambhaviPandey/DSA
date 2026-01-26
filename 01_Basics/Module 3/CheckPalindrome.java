import java.util.*;

public class CheckPalindrome {

  public static void main(String args[]) {

    System.out.println("Enter a string or number to check if it is a palindrome:");

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    String reversedStr = "";

    // Reversing the string
    for (int i = str.length() - 1; i >= 0; i--) {
      reversedStr += str.charAt(i);
    }

    // Checking if the original string and reversed string are the same
    if (str.equals(reversedStr)) {
      System.out.println(str + " is a palindrome.");
    } else {
      System.out.println(str + " is not a palindrome.");
    }

    sc.close();
  }

}
