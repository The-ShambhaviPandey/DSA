import java.util.*;

public class RecursiveAtoI {

    // Time: O(n)
    // Space: O(n) for recursion stack
    
    static final int INT_MIN_VAL = -2147483648;
    static final int INT_MAX_VAL = 2147483647;

    // Recursive helper
    static int helper(String s, int i, long num, int sign) {
        // Base case: end or non-digit
        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int)(sign * num);

        // Update num
        num = num * 10 + (s.charAt(i) - '0');

        // Clamp overflow
        if (sign * num <= INT_MIN_VAL) return INT_MIN_VAL;
        if (sign * num >= INT_MAX_VAL) return INT_MAX_VAL;

        // Recurse
        return helper(s, i + 1, num, sign);
    }

    static int myAtoi(String s) {
        int i = 0;

        // Skip whitespaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Handle sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Recursive helper
        return helper(s, i, 0, sign);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to convert to integer: ");
        String s = sc.nextLine();

        int result = myAtoi(s);
        System.out.println("Converted integer: " + result);

        sc.close();
    }
}
