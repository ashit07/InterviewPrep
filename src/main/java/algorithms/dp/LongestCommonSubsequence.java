package algorithms.dp;

public class LongestCommonSubsequence {
  static String result = "";

  /**
   *  Memoziation
   * @param s1
   * @param s2
   * @param n
   * @param m
   * @param dp
   * @return
   */
  public static int longestCommonSubsequenceTopBottom(String s1, String s2, int n, int m,
      int[][] dp) {
    if (dp[n][m] != 0) {
      return dp[n][m];
    }
    if (n == 0 || m == 0) {
      return 0;
    }
    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      dp[n][m] = 1 + longestCommonSubsequenceTopBottom(s1, s2, n - 1, m - 1, dp);
    } else {
      dp[n][m] = Math.max(longestCommonSubsequenceTopBottom(s1, s2, n - 1, m, dp),
          longestCommonSubsequenceTopBottom(s1, s2, n, m - 1, dp));
    }
    return dp[n][m];
  }

  /**
   * Tabulation
   * 
   * @param s1
   * @param s2
   * @param n
   * @param m
   * @return
   */
  public static int longestCommonSubsequenceBottomUpIterative(String s1, String s2, int n, int m) {
    int[][] store = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          store[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          store[i][j] = 1 + store[i - 1][j - 1];
        } else {
          store[i][j] = Math.max(store[i - 1][j], store[i][j - 1]);
        }

      }
    }
    printLongestCommonSubsequence(s1, s2, n, m, store[n][m], store);
    return store[n][m];
  }

  public static void printLongestCommonSubsequence(String str1, String str2, int n, int m,
      int subSequenceLength, int[][] dp) {
    int i = n;
    int j = m;
    int index = subSequenceLength - 1;
    char[] lcs = new char[subSequenceLength];
    while (i > 0 && j > 0) {
      if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        lcs[index] = str1.charAt(i - 1);
        i--;
        j--;
        index--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        // If the top rectangle value is lesser than the left rectangle value. Move up.
        i--;
      } else {
        //Move left
        j--;
      }

    }
    System.out.print("Subsequence is: ");
    for (int k = 0; k < lcs.length; k++) {
      System.out.print(lcs[k] + "");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    String s1 = "AABCAB";
    String s2 = "AABA";
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    System.out.println(longestCommonSubsequenceTopBottom(s1, s2, s1.length(), s2.length(), dp));

    System.out.println(longestCommonSubsequenceBottomUpIterative(s1, s2, s1.length(), s2.length()));
  }
}
