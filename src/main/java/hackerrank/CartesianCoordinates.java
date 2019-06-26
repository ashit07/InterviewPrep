package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartesianCoordinates {

  public static String isPossible(int a, int b, int c, int d) {
    int temp1 = c;
    int temp2 = d;
    boolean skipC = false;
    boolean skipD = false;
    if (a == c) {
      skipC = true;
    }
    if (b == d) {
      skipD = true;
    }
    while ((!skipC || !skipD) && temp1 >= 0 && temp2 >= 0) {
      if (temp1 == temp2) {
        break;
      }
      if (temp2 > temp1 && !skipD) {
        temp2 = temp2 - temp1;
        if (temp2 == b) {
          skipD = true;
        }
      }
      if (temp1 > temp2 && !skipC) {
        temp1 = temp1 - temp2;
        if (temp1 == a) {
          skipC = true;
        }
      }
    }
    if (skipD && skipC) {
      return "YES";
    }
    return "NO";
  }

  public static int countDistinctPairs(List<Integer> arr, long k) {
    Set set = new HashSet(arr.size());
    Set pairs = new HashSet();
    int count = 0;
    for (int value : arr) {
      int target = (int) k - value;
      // if target number is not in set then add
      if (!set.contains(target)) {
        set.add(value);
      } else {
        System.out.printf("(%d, %d) %n", value, target);
        if (!pairs.contains(value)) {
          pairs.add(value);
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    //  System.out.println(isPossible(1, 4, 5, 9));
    List<Integer> list = Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3);
    System.out.println(countDistinctPairs(list, 12));
  }
}
