package algorithms.dp;


/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 *  E.g.
 *  value[] = {60, 100, 120}
 *  weight[] = {10,20,30}
 *  W=50
 *  
 *  Solution = 220
 *  
 *  
 *  Weight = 10; Value= 60;
 *  Weight = 20, Value = 100
 *  Weight = 30, Value = 120
 *  
 *  Weight = (20+10), Value = 160
 *  Weight = (30+10), Value = 180
 *  Weight = (30+20), Value = 220
 *  Weight = (30+20+10) > 50
 *  
 *  
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
 *  https://www.youtube.com/watch?v=8LusJS5-AGo
 *  
 *
 */
public class Knapsack01 {


  public static int computeTotalValueOfWeightBottomUpDp(int[] value, int[] weight,
      int totalWeight) {
    int[][] wtVal = new int[value.length + 1][totalWeight + 1];
    for (int i = 0; i <= value.length; i++) {
      for (int j = 0; j <= totalWeight; j++) {
        if (i == 0 || j == 0) {
          wtVal[i][j] = 0;
          continue;
        }
        if (j - weight[i - 1] >= 0) {
          //  wtVal[i][j] = Math.max(wtVal[i - 1][j], wtVal[i - 1][j - weight[i - 1]] + value[i - 1]);
          wtVal[i][j] = Math.max(value[i - 1] + wtVal[i - 1][j - weight[i - 1]], wtVal[i - 1][j]);
        } else {
          wtVal[i][j] = wtVal[i - 1][j];
        }
      }
    }
    return wtVal[value.length][totalWeight];
  }

  public static int computeTotalValueOfWeightRecursive(int[] value, int[] weight, int totalWeight,
      int n, int[][] wtVal) {
    if (wtVal[n][totalWeight] != 0) {
      return wtVal[n][totalWeight];
    }
    if (n == 0 || totalWeight == 0) {
      return 0;
    }
    if (weight[n - 1] > totalWeight) {
      wtVal[n][totalWeight] =
          computeTotalValueOfWeightRecursive(value, weight, totalWeight, n - 1, wtVal);
    } else {
      wtVal[n][totalWeight] =
          Math.max(computeTotalValueOfWeightRecursive(value, weight, totalWeight, n - 1, wtVal),
              value[n - 1] + computeTotalValueOfWeightRecursive(value, weight,
                  totalWeight - weight[n - 1], n - 1, wtVal));
    }

    return wtVal[n][totalWeight];
  }


  public static void main(String[] args) {
    int value[] = {0, 60, 100, 120};
    int weight[] = {0, 10, 20, 30};
    int totalWeight = 50;
    System.out.println(computeTotalValueOfWeightBottomUpDp(value, weight, totalWeight));
    int[][] wtVal = new int[value.length + 1][totalWeight + 1];
    System.out.println(
        computeTotalValueOfWeightRecursive(value, weight, totalWeight, value.length, wtVal));
  }

}
