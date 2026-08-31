import java.util.*;

public class SortCharactersByFreq {

    public static char[] sortCharactersByFrequency(String s) {

        // Time: O(n)
        //Space: O(256) = O(1)
        int[] freq = new int[256];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // Array to store distinct characters
        Character[] chars = new Character[256];
        int index = 0;

        // Store characters that occur in the string
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                chars[index++] = (char) i;
            }
        }

        // Sort only the filled portion of the array
        Arrays.sort(chars, 0, index,
                (a, b) -> Integer.compare(freq[b], freq[a]));

        // Create result
        char[] sortedChars = new char[s.length()];
        int resultIndex = 0;

        // Add each character according to its frequency
        for (int i = 0; i < index; i++) {
            char c = chars[i];

            for (int j = 0; j < freq[c]; j++) {
                sortedChars[resultIndex++] = c;
            }
        }

        return sortedChars;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char[] result = sortCharactersByFrequency(s);

        System.out.println("Sorted by frequency: " + new String(result));

        sc.close();
    }
}
