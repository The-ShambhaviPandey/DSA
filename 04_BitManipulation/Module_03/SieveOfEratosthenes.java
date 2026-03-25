import java.util.*;

public class SieveOfEratosthenes {

    public static List<Integer> countPrimesInRanges(int[][] queries) {

        int n = queries.length;

        // Step 1: Find max R
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, queries[i][1]);
        }

        // Step 2: Sieve of Eratosthenes
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);

        if (maxVal >= 0)
            isPrime[0] = false;
        if (maxVal >= 1)
            isPrime[1] = false;

        for (int p = 2; p * p <= maxVal; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= maxVal; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 3: Prefix sum array
        int[] primeCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            primeCount[i] = primeCount[i - 1];
            if (isPrime[i]) {
                primeCount[i]++;
            }
        }

        // Step 4: Answer queries
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            if (L == 0) {
                result.add(primeCount[R]);
            } else {
                result.add(primeCount[R] - primeCount[L - 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queries: ");
        int n = sc.nextInt();

        int[][] queries = new int[n][2];

        System.out.println("Enter queries (L R):");
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        List<Integer> ans = countPrimesInRanges(queries);

        System.out.println("Prime counts in ranges:");
        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}