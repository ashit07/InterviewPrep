package datastructures.string.subsequenceAndsubarrays;
/**
 * 
 * @author junas01
 * A sub-array is a contiguous part of array. 
 * An array that is inside another array. 
 * For example, consider the array [1, 2, 3, 4], 
 * There are 10 non-empty sub-arrays. 
 * The subbarays are (1), (2), (3), (4), (1,2), (2,3), (3,4), (1,2,3), (2,3,4) and (1,2,3,4). 
 * In general, for an array/string of size n, 
 * there are n*(n+1)/2 non-empty subarrays/subsrings.
 * 
 * How to generate all subarrays?
 * We can run two nested loops, the outer loop picks starting element 
 * and inner loop considers all elements on right of the picked elements as ending element of subarray.
 */
public class SubarrayGenerator {
   static int arr[] = new int[] {1,2,3,4};
	static void subArray(int n) {
		for(int i=0; i< n; i++) {
			for(int j=i; j< n; j++) {
				for(int k=i; k<=j; k++) {
					System.out.print(arr[k]+"");
				}
				System.out.print(",");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		
		subArray(arr.length);
	}
}
