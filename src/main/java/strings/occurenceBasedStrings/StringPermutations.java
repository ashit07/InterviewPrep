package strings.occurenceBasedStrings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

  public static void calculatePermutations(String str, String ans) {

    if (str.length() == 0) {
      System.out.print(ans + ",");
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      String ros = str.substring(0, i) + str.substring(i + 1);
      calculatePermutations(ros, ans + c);
    }
  }

  //Function to print all the distinct 
  // permutations of str 
  public static void printDistinctPermutn(String str, String ans, boolean[] alpha) {
    if (str.length() == 0) {
      System.out.print(ans + ",");
      return;
    }


    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      String ros = str.substring(0, i) + str.substring(i + 1);

      if (alpha[c - 'a'] == false)
        calculatePermutations(ros, ans + c);
      alpha[c - 'a'] = true;
    }
  }

}
