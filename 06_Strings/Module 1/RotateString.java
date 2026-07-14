import java.util.Scanner;

public class RotateString {

  // BRUTE FORCE APPROACH
  // Time Complexity: O(n²)
  // Space Complexity: O(n)

  public static boolean rotateBrute(String s, String goal) {

    if (s.length() != goal.length())
      return false;

    String rotated = s;

    for (int i = 0; i < s.length(); i++) {

      // Left Rotate by One Position
      rotated = rotated.substring(1) + rotated.charAt(0);

      if (rotated.equals(goal))
        return true;
    }

    return s.equals(goal);
  }

  // OPTIMAL APPROACH (s + s)
  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static boolean rotateOptimal(String s, String goal) {

    if (s.length() != goal.length())
      return false;

    String doubled = s + s;

    return doubled.contains(goal);
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter first string:");
    String s = sc.nextLine();

    System.out.println("Enter goal string:");
    String goal = sc.nextLine();

    sc.close();

    boolean brute = rotateBrute(s, goal);
    System.out.println("Brute Result: " + brute);

    boolean optimal = rotateOptimal(s, goal);
    System.out.println("Optimal Result: " + optimal);
  }
}