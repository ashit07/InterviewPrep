package hackerrank;

import java.util.Arrays;


public class Problem {

  static String[] isTriangle(int[] a, int[] b, int[] c) {
    String[] result = new String[a.length];
    for (int i = 0; i < a.length; i++) {
      int[] arr = {a[i], b[i], c[i]};
      if (isPossibleTriangle(arr, arr.length)) {
        result[i] = "Yes";
      } else {
        result[i] = "No";
      }
    }
    return result;
  }

  static boolean isPossibleTriangle(int[] arr, int N) {
    if (N < 3) {
      return false;
    }
    Arrays.sort(arr);
    for (int i = 0; i < N - 2; i++)
      if (arr[i] + arr[i + 1] > arr[i + 2])
        return true;
    return false;
  }



  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 1, 2};
    int N = arr.length;

    // if (isPossibleTriangle(arr, N))
    // System.out.println("Yes");
    // else
    // System.out.println("No");


    int[] a = {7, 10, 7};
    int[] b = {2, 3, 4};
    int[] c = {2, 7, 4};
    String[] arr2 = isTriangle(a, b, c);
    for (String s : arr2) {
      System.out.println(s);
    }
  }

}
