package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctPairsWithSum {
  public static int countDistinctPairs(List<Integer> arr, long k) {
    Set<Integer> set = new HashSet<>(arr.size());
    Set<Integer> pairs = new HashSet<>();
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
    List<Integer> list = Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3);
    System.out.println(countDistinctPairs(list, 12));
  }
}
