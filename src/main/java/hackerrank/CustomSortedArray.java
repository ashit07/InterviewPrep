package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CustomSortedArray {

  public static int swaps = 0;

  public static int findMinSwapsForSortedArray(List<Integer> arr) {
    swaps = findMinSwaps(arr, 0, arr.size() - 1);
    return swaps;
  }

  private static int findMinSwaps(List<Integer> arr, int start, int end) {
    int i = start;
    int j = end;
    int swaps = 0;
    for (int k = i; k < j; k++) {
      if (arr.get(i) % 2 != 0 && arr.get(j) % 2 == 0) {
        swap(arr, i, j);
        i++;
        j--;
        swaps++;
      } else if (arr.get(i) % 2 == 0 && arr.get(i) % 2 != 0) {
        i++;
        j--;
      } else if (arr.get(j) % 2 == 0 && arr.get(i) % 2 == 0) {
        i++;
      } else {
        j--;
      }

    }
    return swaps;
  }

  static int segregateEvenOdd(List<Integer> arr) {
    /* Initialize left and right indexes */
    int left = 0, right = arr.size() - 1;
    int count = 0;
    while (left < right) {
      /* Increment left index while we see 0 at left */
      while (arr.get(left) % 2 == 0 && left < right)
        left++;

      /* Decrement right index while we see 1 at right */
      while (arr.get(right) % 2 == 1 && left < right)
        right--;

      if (left < right) {
        /* Swap arr[left] and arr[right] */
        int temp = arr.get(left);
        arr.set(left, arr.get(right));
        arr.set(right, temp);
        left++;
        right--;
        count++;
      }
    }
    return count;
  }

  private static void swap(List<Integer> arr, int i, int j) {
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  // arr[] = {13,10,21,20}

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(5);
    arr.add(8);
    arr.add(5);
    arr.add(11);
    arr.add(4);
    arr.add(6);
    // System.out.println(findMinSwapsForSortedArray(arr));
    System.out.println(segregateEvenOdd(arr));
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i) + ", ");
    }



  }

}
