import java.util.*;

public class CountFrequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = sc.nextLine();

    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    System.out.println("Character frequencies:");
    for (char key : map.keySet()) {
      System.out.println(key + ": " + map.get(key));
    }

    sc.close();
  }
}
