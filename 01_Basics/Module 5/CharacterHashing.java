import java.util.*;

class CharacterHashing {
  public static void main(String[] args) {
    System.out.println("Enter the string:");
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();

    int[] hash = new int[52]; // 26 lowercase + 26 uppercase

    // Precompute frequencies
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch >= 'a' && ch <= 'z') {
        hash[ch - 'a']++;
      } else if (ch >= 'A' && ch <= 'Z') {
        hash[ch - 'A' + 26]++;
      }
    }

    // Example queries
    System.out.println("Enter number of queries:");
    int q = sc.nextInt();
    while (q-- > 0) {
      System.out.println("Enter character to query:");
      char query = sc.next().charAt(0);

      System.out.println("Frequency of " + query + ":");

      if (query >= 'a' && query <= 'z') {
        System.out.println(hash[query - 'a']);
      } else if (query >= 'A' && query <= 'Z') {
        System.out.println(hash[query - 'A' + 26]);
      } else {
        System.out.println(0);
      }
    }

    sc.close();
  }
}
