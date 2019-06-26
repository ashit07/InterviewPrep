package strings.subsequence;

/**
 * 
 * @author junas01
 *
 *         Longest subsequence where every character appears at-least k times Given a string and a
 *         number k, find the longest subsequence of a string where every character appears at-least
 *         k times.
 * 
 *         Examples:
 * 
 *         Input : str = "geeksforgeek" k = 2 
 *         Output : geeskgeeks 
 *         Every character in the output subsequence appears at-least 2 times.
 * 
 *         Input : str = "aabbaabacabb" k = 5 Output : aabbaabaabb
 */

public class LongestSubsequenceWithEveryCharKTimes {

  /** 
   * Method 2 (Efficient way)
  1. Find the frequency of the string and store it in an integer array of size 26 representing the alphabets.
  2. After finding the frequency iterate the string character by character and 
     if the frequency of that character is greater than or equal to the required number of repetitions then print that character then and there only.
   * 
   */
  static final int MAX_CHARS = 26;

  static void longestSubsequenceWithK(String str, int k) {
    int n = str.length();
    int freq[] = new int[26];
    for (int i = 0; i < n; i++) {
      freq[str.charAt(i) - 'a']++;
    }

    for (int i = 0; i < n; i++) {
      if (freq[str.charAt(i) - 'a'] >= k) {
        System.out.print(str.charAt(i));
      }
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    longestSubsequenceWithK("geeksforgeeks", 2);
    longestSubsequenceWithK("aabbaabacabb", 5);
  }
}
