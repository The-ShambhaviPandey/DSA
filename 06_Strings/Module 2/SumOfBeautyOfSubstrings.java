import java.util.*;

public class SumOfBeautyOfSubstrings {

    public static int beautySum(String s) {

        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {

            Map<Character, Integer> freqMap = new HashMap<>();

            for (int j = i; j < n; j++) {

                char c = s.charAt(j);

                // Add current character to the substring
                freqMap.put(
                    c,
                    freqMap.getOrDefault(c, 0) + 1
                );

                // Find maximum and minimum frequency
                int maxFreq = Collections.max(freqMap.values());
                int minFreq = Collections.min(freqMap.values());

                // Beauty = max frequency - min frequency
                sum += maxFreq - minFreq;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = beautySum(s);
        System.out.println("Sum of beauty of all substrings: " + result);

        sc.close();
    }
}

