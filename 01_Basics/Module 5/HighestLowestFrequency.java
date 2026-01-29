import java.util.*;

public class HighestLowestFrequency {

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

    char highestFreqChar = '\0';
    char lowestFreqChar = '\0';
    int highestFreq = Integer.MIN_VALUE;
    int lowestFreq = Integer.MAX_VALUE;

    for (char key : map.keySet()) {
      int freq = map.get(key);
      if (freq > highestFreq) {
        highestFreq = freq;
        highestFreqChar = key;
      }
      if (freq < lowestFreq) {
        lowestFreq = freq;
        lowestFreqChar = key;
      }
    }

    System.out.println("Character with highest frequency: " + highestFreqChar + " (" + highestFreq + ")");
    System.out.println("Character with lowest frequency: " + lowestFreqChar + " (" + lowestFreq + ")");

    sc.close();
  }

}
