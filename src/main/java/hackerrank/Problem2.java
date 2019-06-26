package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Problem2 {

  public static <T> int deleteProducts(List<Integer> ids, int m) {
    Set<Integer> idsRemainingSet = new HashSet<>();
    Comparator<Entry<Integer, Integer>> valuesComparator =
        new Comparator<Map.Entry<Integer, Integer>>() {

          @Override
          public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
            Integer value1 = entry1.getValue();
            Integer value2 = entry2.getValue();
            return value1.compareTo(value2);
          }
        };
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer id : ids) {
      if (map.containsKey(id)) {
        int val = map.get(id).intValue();
        map.put(id, ++val);
      } else {
        map.put(id, 1);
      }
    }

    Set<Entry<Integer, Integer>> set = map.entrySet();
    List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Map.Entry<Integer, Integer>>(set);
    Collections.sort(listOfEntries, valuesComparator);

    for (Entry<Integer, Integer> e : listOfEntries) {
      int count = e.getValue().intValue();
      if (m - count >= 0) {
        m = m - count;
        continue;
      } else {
        idsRemainingSet.add(e.getKey());
      }
    }
    return idsRemainingSet.size();
  }



  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(1);
    arr.add(2);
    arr.add(2);
    int N = 3;
    System.out.println(deleteProducts(arr, N));
  }


}
