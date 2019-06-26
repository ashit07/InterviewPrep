package algorithms.dp;

/**
 * Given stockc prices for certain days and at most k transactions how to buy and sell
 * to maximize profit.
 *
 * Time complexity - O(number of transactions * number of days)
 * Space complexity - O(number of transcations * number of days)
 *
 * https://leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 * 
 * 
 *  int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
 *  k=3
 *  
 */
public class StockBuySellKTransactions {

  /**
   * This is slow method but easier to understand.
   * Time complexity is O(k * number of days ^ 2)
   * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
   */
  public static int maxProfitSlowSolution(int[] prices, int k) {
    if (k == 0 || prices.length == 0) {
      return 0;
    }
    int[][] T = new int[k + 1][prices.length];

    for (int i = 1; i < T.length; i++) {
      for (int j = 1; j < T[0].length; j++) {
        int maxVal = 0;
        for (int m = 0; m < j; m++) {
          maxVal = Math.max(maxVal, (prices[j] - prices[m] + T[i - 1][m]));
        }
        T[i][j] = Math.max(T[i][j - 1], maxVal);
      }
    }
    return T[k][prices.length - 1];
  }

  /**
   * This is faster method which does optimization on slower method
   * Time complexity here is O(K * number of days)
   *
   * Formula is
   * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
   * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
   */
  public static int maxProfitFastWithMaxDiff(int[] prices, int k) {
    if (k == 0 || prices.length == 0) {
      return 0;
    }
    int[][] T = new int[k + 1][prices.length];

    for (int i = 1; i < T.length; i++) {
      int maxDiff = -prices[0];
      for (int j = 1; j < T[0].length; j++) {
        T[i][j] = Math.max(T[i][j - 1], maxDiff + prices[j]);
        maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
      }
    }
    return T[k][prices.length - 1];
  }

  public static void main(String[] args) {
    int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
    int k = 3;
    System.out.println(maxProfitSlowSolution(prices, k));
    System.out.println(maxProfitFastWithMaxDiff(prices, k));

  }
}
