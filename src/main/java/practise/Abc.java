package practise;

import java.util.Scanner;

public class Abc {
  static int compareVersion(String currentVersion, String upgradeVersion) {

    Scanner s1 = new Scanner(currentVersion);
    Scanner s2 = new Scanner(upgradeVersion);
    s1.useDelimiter("\\.");
    s2.useDelimiter("\\.");

    int result = 0;
    while (s1.hasNextInt() && s2.hasNextInt()) {
      int v1 = s1.nextInt();
      int v2 = s2.nextInt();
      if (v1 < v2) {
        result = -1;
        break;
      } else if (v1 > v2) {
        result = 1;
        break;
      }
    }

    s1.close();
    s2.close();

    return result;
  }

  public static int abc() {
    int i = 1;
    try {
      i = 2;
      throw new Exception();
    } catch (Exception ex) {
      return i;
    } finally {
      i = 3;
    }
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("2.5.3", "2.5.4"));
    System.out.println(abc());
  }
}
