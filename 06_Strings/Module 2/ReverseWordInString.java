import java.util.*;

public class ReverseWordInString {

    // Time:  O(n)
    // Space: O(n)
    
    public static String reverseEveryWordBrute(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder reversed = new StringBuilder(word);
            reversed.reverse();

            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }

    // Time: O(n)
    // Space: O(n), but O(1) for auxilary space.
    public static String reverseEveryWordOptimal(String s) {

        char[] chars = s.toCharArray();

        int start = 0;

        for (int i = 0; i <= chars.length; i++) {

            // End of word
            if (i == chars.length || chars[i] == ' ') {

                int left = start;
                int right = i - 1;

                // Reverse current word
                while (left < right) {

                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;

                    left++;
                    right--;
                }

                // Next word starts after the space
                start = i + 1;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String reversedBrute = reverseEveryWordBrute(s);
        System.out.println("Reversed every word (Brute Force): " + reversedBrute);

        String reversedOptimal = reverseEveryWordOptimal(s);
        System.out.println("Reversed every word (Optimal): " + reversedOptimal);

        sc.close();
    }


    
}
