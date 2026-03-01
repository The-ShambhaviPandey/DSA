import java.util.*;

public class StockBuySell {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int n = sc.nextInt();

    int[] prices = new int[n];
    System.out.println("Enter the stock prices: ");
    for (int i = 0; i < n; i++) {
      prices[i] = sc.nextInt();
    }

    System.out.println("Maximum Profit: " + maxProfit(prices));
    sc.close();
  }

  // Brute Force Approach - O(n^2)
  public static int maxProfitBrute(int[] prices) {
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }

    return maxProfit;
  }

  // Optimal Approach - O(n)
  public static int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }

    return maxProfit;
  }
}
