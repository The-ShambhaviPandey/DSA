import java.util.*;

public class RomanToInt {

    public int romanToInt(String s) {
        int res = 0;
        Map <Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);     
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res+roman.get(s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String s = sc.nextLine();

        RomanToInt converter = new RomanToInt();
        int result = converter.romanToInt(s);

        System.out.println("Integer value: " + result);

        sc.close();
    }
  
}
