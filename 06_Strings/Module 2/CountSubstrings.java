import java.util.*;

public class CountSubstrings {

    public static int atMostKDistinct(String s, int k) {
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

    public static int countSubstring (String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.print("Enter the number of distinct characters (k): ");
        int k = sc.nextInt();

        int result = countSubstring(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);

        sc.close();
    }
    
}
