package arrays;

/**
 * 
 * @author junas01
 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 * 
 * Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.
 * 
 */
public class SmallestSubArraySum {

  //Returns length of smallest subarray with sum greater than x. 
  // If there is no subarray with given sum, then returns n+1 
  // int arr1[] = {1, 4, 45, 6, 10, 19}; 
  // int x = 51; 
  static int computeSmallestSubArr(int[] arr, int n, int x) {
    int start = 0, end = 0;
    int min_len = n + 1;
    int curr_sum = 0;

    while (end < n) {
      while (curr_sum < x && end < n) {
        //Below Used only for negative numbers
        // Ignore subarrays with  
        // negative sum if x is 
        // positive. 
        if (curr_sum <= 0 && x > 0) {
          start = end;
          curr_sum = 0;
        }
        //Above Used only for negative numbers
        curr_sum += arr[end++];

      }
      while (curr_sum > x && start < n) {
        if (end - start < min_len) {
          min_len = end - start;
        }
        curr_sum -= arr[start++];
      }

    }
    return min_len;
  }
}
