import java.util.*;

public class BitFlipCountToConvertAtoB {

    public static int countFlipsBrute(int a, int b) {
        int xor = a ^ b;
        int count = 0;

        while (xor > 0) {
            if ((xor & 1) == 1)
                count++;
            xor = xor >> 1;
        }

        return count;
    }

    public static int countFlipsOptimal(int a, int b) {
        int xor = a ^ b;
        int count = 0;

        while (xor > 0) {
            xor = xor & (xor - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter A: ");
        int a = sc.nextInt();

        System.out.print("Enter B: ");
        int b = sc.nextInt();

        System.out.println("Brute: " + countFlipsBrute(a, b));
        System.out.println("Optimal: " + countFlipsOptimal(a, b));

        sc.close();
    }
}