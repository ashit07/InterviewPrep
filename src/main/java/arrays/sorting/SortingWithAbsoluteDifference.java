package arrays.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import arrays.ArrayUtilityFunctions;

/**
 * 
 * @author junas01
 * https://www.geeksforgeeks.org/sort-an-array-according-to-absolute-difference-with-given-value/
 * 
 * Sort an array according to absolute difference with given value
Given an array of n distinct elements and a number x, arrange array elements according to the absolute difference with x, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

Examples :

Input : arr[] : x = 7, arr[] = {10, 5, 3, 9, 2}
Output : arr[] = {5, 9, 10, 3, 2}
Explanation:
7 - 10 = 3(abs)
7 - 5 = 2
7 - 3 = 4 
7 - 9 = 2(abs)
7 - 2 = 5
So according to the difference with X, 
elements are arranged as 5, 9, 10, 3, 2.

Input : x = 6, arr[] = {1, 2, 3, 4, 5}   
Output :  arr[] = {5, 4, 3, 2, 1}

Input : x = 5, arr[] = {2, 6, 8, 3}   
Output :  arr[] = {6, 3, 2, 8}
 */
public class SortingWithAbsoluteDifference {

  public static void sortArrayWithAbsoluteDiff(int[] arr, int x) {
    Map<Integer, List<Integer>> sortedEntries = new TreeMap<>();
    for (int i : arr) {
      int key = Math.abs(x - i);
      if (!sortedEntries.containsKey(key)) {
        List<Integer> list = new LinkedList<>();
        list.add(i);
        sortedEntries.put(key, list);
      } else {
        sortedEntries.get(key).add(i);
      }
    }
    Set<Integer> keySet = sortedEntries.keySet();
    int index = 0;
    for (int i : keySet) {
      List<Integer> val = sortedEntries.get(i);
      for (int j = 0; j < val.size(); j++) {
        arr[index++] = val.get(j);
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};
    sortArrayWithAbsoluteDiff(arr, 6);
    ArrayUtilityFunctions.displayArray(arr);
    int arr2[] = {2, 6, 8, 3};
    sortArrayWithAbsoluteDiff(arr2, 5);
    ArrayUtilityFunctions.displayArray(arr2);
  }
}
