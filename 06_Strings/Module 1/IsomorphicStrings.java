import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n²)
  // Space Complexity: O(n)

  public static boolean isomorphicBrute(String s, String t) {

    if (s.length() != t.length())
      return false;

    for (int i = 0; i < s.length(); i++) {

      char ch1 = s.charAt(i);
      char ch2 = t.charAt(i);

      // Check mapping from s -> t
      for (int j = i + 1; j < s.length(); j++) {

        if (s.charAt(j) == ch1 && t.charAt(j) != ch2)
          return false;

        if (t.charAt(j) == ch2 && s.charAt(j) != ch1)
          return false;
      }
    }

    return true;
  }

  // OPTIMAL APPROACH (HASHMAP)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static boolean isomorphicOptimal(String s, String t) {

    if (s.length() != t.length())
      return false;

    HashMap<Character, Character> mapST = new HashMap<>();
    HashMap<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {

      char ch1 = s.charAt(i);
      char ch2 = t.charAt(i);

      if (mapST.containsKey(ch1)) {

        if (mapST.get(ch1) != ch2)
          return false;

      } else {

        mapST.put(ch1, ch2);
      }

      if (mapTS.containsKey(ch2)) {

        if (mapTS.get(ch2) != ch1)
          return false;

      } else {

        mapTS.put(ch2, ch1);
      }
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter first string:");
    String s = sc.nextLine();

    System.out.println("Enter second string:");
    String t = sc.nextLine();

    sc.close();

    boolean brute = isomorphicBrute(s, t);
    System.out.println("Brute Result: " + brute);

    boolean optimal = isomorphicOptimal(s, t);
    System.out.println("Optimal Result: " + optimal);
  }
}