package datastructures.string.subsequenceAndsubarrays;

import java.math.BigInteger;

/**
 * 
 * @author junas01 
 *   A subsequence is a sequence that can be derived from another
 *   sequence by zero or more elements, without changing the order of the
 *   remaining elements. 
 *   For the same example, there are 15 sub-sequences.
 *   They are (1), (2), (3), (4), (1,2), (1,3),(1,4), (2,3), (2,4), (3,4),
 *   (1,2,3), (1,2,4), (1,3,4), (2,3,4), (1,2,3,4). 
 *   More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty
 *   sub-sequences in total. 
 *   A string example to differentiate: 
 *   Consider strings “geeksforgeeks” and “gks”. 
 *   “gks” is a subsequence of “geeksforgeeks” but not a substring. 
 *   “geeks” is both a subsequence and subarray. 
 *   Every subarray is a subsequence.
 *   More specifically, Subsequence is a generalization of substring.
 * 
 *   How to generate all Subsequences? 
 *   We can use algorithm to generatepower set for generation of all subsequences.
 * 

 */
public class SubSequenceGenerator {
	static int arr[] = new int[] { 1, 2, 3, 4 };

	static void printSequences(int n) {
		/* Number of subsequences is (2**n -1)*/
		int opSize = (int) Math.pow(2, n);

		/* Run from counter 000..1 to 111..1*/
		for (int counter = 1; counter < opSize; counter++) {

			for (int j = 0; j < n; j++) {
				/* Check if jth bit in the counter is set
				If set then print jth element from arr[] */
				//				System.out.println("----");
				//				System.out.println("Counter: " + BigInteger.valueOf(counter));
				//				System.out.println(j);
				//				System.out.println(BigInteger.valueOf(counter).testBit(j));
				//				System.out.println("------");
				if (BigInteger.valueOf(counter).testBit(j)) {
					System.out.print(arr[j] + "");
				}
			}
			System.out.print(",");
		}
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		System.out.println("All Non-empty Subsequences");
		printSequences(arr.length);
	}
}
