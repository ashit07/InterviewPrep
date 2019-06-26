package arrays;

public class RotateArrayReversalAlgo {

  //Will Perform Left Rotate
  //Output is : 4, 5, 6, 7, 8, 9, 10, 1, 2, 3
  public static void leftRotateArray(int[] arr, int start, int end, int positions) {
    //Arr: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    reverseArray(arr, start, start + positions - 1);
    //{3, 2, 1, 4, 5, 6, 7, 8, 9, 10}
    reverseArray(arr, start + positions, end);
    //{3, 2, 1, 10, 9, 8, 7, 6, 5, 4}
    reverseArray(arr, start, end);
    //{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}
  }

  //Will perform right rotate
  //Output is: 8, 9, 10, 1, 2, 3, 4, 5, 6, 7
  public static void rightRotateArray(int[] arr, int start, int end, int positions) {
    //Arr: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    reverseArray(arr, start, end);
    //{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
    reverseArray(arr, start, start + positions - 1);
    //{8, 9, 10, 7, 6, 5, 4, 3, 2, 1}
    reverseArray(arr, start + positions, end);
    //{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}

  }

  public static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }


  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int rotatePos = 3;
    leftRotateArray(arr, 0, arr.length - 1, rotatePos);
    ArrayUtilityFunctions.displayArray(arr);
    //Output is : 4, 5, 6, 7, 8, 9, 10, 1, 2, 3
    System.out.println("------");
    int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    rightRotateArray(arr2, 0, arr.length - 1, rotatePos);
    ArrayUtilityFunctions.displayArray(arr2);
    // Output is: 8, 9, 10, 1, 2, 3, 4, 5, 6, 7
  }

}
