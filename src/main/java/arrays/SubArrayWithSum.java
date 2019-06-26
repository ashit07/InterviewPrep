package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSum {

  // Does not handles negative numbers
  static void subArrayWithSum(int[] arr, int n, int x) {
    int start = 0, curr_sum = arr[0];
    for (int i = 1; i < n; i++) {
      while (curr_sum > x && start < n) {
        curr_sum -= arr[start++];
      }
      if (curr_sum == x) {
        System.out.println("Starting index: " + start + " ending index: " + (i - 1));
        break;
      }
      curr_sum += arr[i];
    }
  }

  //Handles negative numbers
  /*
   * int[] arr = {10, 2, -2, -20, 10}; 
        int n = arr.length; 
        int sum = -10; 
   */
  static void subarrayWithSumHashMap(int[] arr, int n, int x) {
    Map<Integer, Integer> vals = new HashMap<>();
    int curr_sum = 0;
    int start = 0, end = -1;

    for (int i = 0; i < n; i++) {
      curr_sum += arr[i];
      if (curr_sum - x == 0) {
        start = 0;
        end = i;
        break;
      }
      if (vals.containsKey(curr_sum - x)) {
        start = vals.get(curr_sum - x) + 1;
        end = i;
        break;
      }
      vals.put(curr_sum, i);
    }
    if (end > 0) {
      System.out.println("Starting index: " + start + " ending index: " + end);
    } else {
      System.out.println("No such subarray exists.");
    }
  }

  public static void main(String[] args) {
    int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
    int n = arr.length;
    int x = 23;
    subArrayWithSum(arr, n, x);

    int[] arr1 = {10, 2, -2, -20, 10};
    int n1 = arr1.length;
    int x1 = -10;
    subarrayWithSumHashMap(arr1, n1, x1);
  }
}
