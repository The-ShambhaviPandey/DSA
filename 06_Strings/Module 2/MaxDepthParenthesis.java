import java.util.*;

public class MaxDepthParenthesis {

    //Time: O(n)
    //Space: O(1)

    public static int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with parentheses: ");
        String s = sc.nextLine();

        int depth = maxDepth(s);
        System.out.println("Maximum depth of nested parentheses: " + depth);

        sc.close();
    }
    
}
