package datastructures.string.subsequenceAndsubarrays;

/**
 * 
 * @author junas01
 * Longest Subsequence Where Every character appears at-least k times.
 */
public class CountSubsequenceElements {
	// Recursive function to find the number of times
	// the second string occurs in the first string,
	// whether continuous or discontinuous
	static int count(String a, String b, int m, int n) {
		// If both first and second string is empty,
		// or if second string is empty, return 1
		System.out.println(a + "----" + m);
		System.out.println(b + "----" + n);
		if ((m == 0 && n == 0) || n == 0)
			return 1;

		// If only first string is empty and 
		// second string is not empty, return 0
		if (m == 0)
			return 0;

		// If last characters are same
		// Recur for remaining strings by
		// 1. considering last characters of 
		// both strings
		// 2. ignoring last character of 
		// first string
		if (a.charAt(m - 1) == b.charAt(n - 1))
			return count(a, b, m - 1, n - 1) + count(a, b, m - 1, n);
		else
			// If last characters are different,  
			// ignore last char of first string 
			// and recur for  remaining string
			return count(a, b, m - 1, n);
	}

	// Driver code
	public static void main(String[] args) {
		String a = "GeeksforGeeks";
		String b = "Gks";
		System.out.println(count(a, b, a.length(), b.length()));

	}
}