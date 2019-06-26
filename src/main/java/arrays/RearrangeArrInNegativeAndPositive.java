package arrays;

/**
 * 
 * @author junas01
 * 
 * Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 
This question has been asked at many places (See this and this)

The above problem can be easily solved if O(n) extra space is allowed. 
It becomes interesting due to the limitations that O(1) extra space and order of appearances.
The idea is to process array from left to right. 
While processing, find the first out of place element in the remaining unprocessed array. 
An element is out of place if it is negative and at odd index, or it is positive and at even index. 
Once we find an out of place element, we find the first element after it with opposite sign. 
We right rotate the subarray between these two elements (including these two).


Input:  arr[] = {1, 2, 3, -4, -1, 4}
Step 1: Traverse arr from left to right and find first out of place element.
    int outOfPlaceElementIndex = 0 (as value = 1 is positive and it is at even index) 
Step 2: As outOfPlaceElementIndex is with positive value, Find 1st element with negative sign after outOfPlaceElementIndex
    int negativeIndex= 3 and val is -4
Step 3: Right Rotate subarray such that startIndex = outOfPlaceElementIndex = 0 and endIndex = negativeIndex= 3
After rotation, array comes like: 
    arr[] = {-4, 1, 2, 3, -1 , 4}
    
Repeat step 1:
    int outOfPlaceElementIndex = 2 (as value = 2 is positive and it is at even index) 
Repeat step 2: as  outOfPlaceElementIndex is with positive value, Find 1st element with negative sign after outOfPlaceElementIndex
    int negativeIndex= 4 and val is -1
Repeat step 3:  Right Rotate subarray such that startIndex = outOfPlaceElementIndex = 2 and endIndex = negativeIndex= 4
After rotation, array comes like: 
        arr[] = {-4, 1, -1, 2, 3, 4}

Repeat step 1: 
int outOfPlaceElementIndex = 4 (as value =32 is positive and it is at even index) 
Repeat step 2: as  outOfPlaceElementIndex is with positive value, Find 1st element with negative sign after outOfPlaceElementIndex
    as there is no negative value available, return

 *
 */
public class RearrangeArrInNegativeAndPositive {

  static void rearrangeInNegativeAndPositive(int[] arr, int n) {
    int outOfPlaceElementIndex = -1;
    for (int i = 0; i < n; i++) {
      if ((arr[i] > 0 && i % 2 == 0) || (arr[i] < 0 && i % 2 != 0)) {
        outOfPlaceElementIndex = i;
      }
      if (outOfPlaceElementIndex > -1) {
        int validElementIndex = -1;
        if (arr[outOfPlaceElementIndex] >= 0) {
          for (int j = outOfPlaceElementIndex; j < n; j++) {
            if (arr[j] < 0) {
              validElementIndex = j;
              break;
            }
          }
        } else {
          for (int j = outOfPlaceElementIndex; j < n; j++) {
            if (arr[j] >= 0) {
              validElementIndex = j;
              break;
            }
          }
        }
        if (validElementIndex > -1) {
          RotateArrayReversalAlgo.rightRotateArray(arr, outOfPlaceElementIndex, validElementIndex,
              1);
        }
        outOfPlaceElementIndex = -1;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, -4, -1, 4};
    rearrangeInNegativeAndPositive(arr, arr.length);
    ArrayUtilityFunctions.displayArray(arr);
  }
}
