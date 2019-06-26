package practise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonNullFieldsReplacer {

  public static String removeNullsRegex(String json) {

    // Pattern p = Pattern.compile("\"([^\"]*)\"");
    Pattern p = Pattern.compile("\"([^\"]*\":\\s?null,)");

    Matcher m = p.matcher(json);
    while (m.find()) {
      System.out.println("--------");
      System.err.println(m.group(0));
      // System.err.println(m.group(1));
    }
    // ,\\s?\\s?\"([^\"]*\":\\s?null,?)

    return json.replaceAll("\"([^\"]*\":\\s?null,)", "")
        .replaceAll(",\\s?\\s?\"([^\"]*\":\\s?null)", "");
  }

  public static String removeNullJsonParsing(String json) {

    return json;
  }

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

  public static void main(String[] args) {
    String json =
        "{\"header\": {\"tenant_id\": \"sprint\", \"doc_type_id\": \"tweet\", \"unique_id\": \"3d96bc07-746b-4ca3-babd-426ffd4af591\", \"external_version\": null, \"parent_id\": null, \"doc_type_version\": \"2\", \"product_id\": \"ao\"}, \"body\": {\"name\": {\"val1\":null,\"app_key\": 322, \"test_key2\": null, \"test_key\": \"abc\", \"startTime\": null, \"app_id\": 23, \"test_key3\": null, \"test_key_number\": null}}}";
    // System.out.println("------1------");
    // System.out.println(json);
    // String removedNullJson = removeNullsRegex(json);
    // System.out.println(removedNullJson);
    // System.out.println("------2------");
    // String json1 =
    // "{\"header\": {\"tenant_id\": \"sprint\", \"doc_type_id\": \"tweet\", \"unique_id\":
    // \"2012e99c-2fe0-4c51-afaa-02adc64bd77a\", \"external_version\": null, \"parent_id\": null,
    // \"doc_type_version\": \"1\", \"product_id\": \"ao\"}, \"body\": {\"name\": {\"app_key\":
    // 12.0, \"test_key\": null, \"app_id\": 10}}}";
    // System.out.println(removeNullsRegex(json1));
    System.out.println("-------------");

    System.out.println(compareVersion("2.5.3", "2.5.4"));
  }
}
