package arrays;

public class SegregateZerosAndOne {

  /**
   * 
   * @param arr
   * @param n
   * 
  Maintain two indexes. Initialize first index left as 0 and second index right as n-1.
  
  Do following while left < right
  a) Keep incrementing index left while there are 0s at it
  b) Keep decrementing index right while there are 1s at it
  c) If left < right then exchange arr[left] and arr[right]
   * 
   */
  public static void segregateZerosAndOnes(int[] arr, int n) {
    int leftPtr = 0;
    int rightPtr = n - 1;
    while (leftPtr < rightPtr) {
      while (arr[leftPtr] == 0 && leftPtr < rightPtr) {
        leftPtr++;
      }
      while (arr[rightPtr] == 1 && leftPtr < rightPtr) {
        rightPtr--;
      }
      if (leftPtr < rightPtr) {
        arr[leftPtr] = 0;
        arr[rightPtr] = 1;
        leftPtr++;
        rightPtr--;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    segregateZerosAndOnes(arr, arr.length);
    ArrayUtilityFunctions.displayArray(arr);
  }
}
