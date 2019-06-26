package strings.subsequence;

/**
 * 
 * @author junas01
 *
 * Given two strings str1 and str2, find if str1 is a subsequence of str2. 
 * A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements (source: wiki). 
 * Expected time complexity is linear.

Examples :

Input: str1 = "AXY", str2 = "ADXCPY"
Output: True (str1 is a subsequence of str2)

Input: str1 = "AXY", str2 = "YADXCP"
Output: False (str1 is not a subsequence of str2)

Input: str1 = "gksrek", str2 = "geeksforgeeks"
Output: True (str1 is a subsequence of str2)
 */
public class StringSubSequenceOfSecond {

  /**
   * The idea is simple, we traverse both strings from one side to other side (say from rightmost character to leftmost). 
   * If we find a matching character, we move ahead in both strings. Otherwise we move ahead only in str2.
   */

  static boolean isSubStringIterative(String str1, String str2) {
    int n1 = str1.length();
    int n2 = str2.length();

    int indexToCheck1 = n1 - 1;
    for (int i = n2 - 1; i >= 0 && indexToCheck1 >= 0; i--) {
      if (str2.charAt(i) == str1.charAt(indexToCheck1)) {
        indexToCheck1--;
      }
    }
    if (indexToCheck1 < 0) {
      System.out.println("True");
      return true;
    }
    System.out.println("False");
    return false;
  }


  public static void main(String[] args) {
    isSubStringIterative("AXY", "ADXCPY");
    isSubStringIterative("gksrek", "geeksforgeeks");
  }
}
