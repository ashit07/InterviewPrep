import java.util.Stack;

public class CiscoHackerRank {


  public static int getSum(int nVal) {

    int sum = 0;
    for (int i = 1; i < nVal; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;

  }

  public static void addTwoNumbers(SinglyLinkedListNode num1, SinglyLinkedListNode num2) {
    SinglyLinkedListNode resultNode = null;
    SinglyLinkedListNode prevNode = null;
    SinglyLinkedListNode tempNode = null;
    int sum = 0;
    int carry = 0;
    while (num1 != null || num2 != null) {
      sum = carry + (num1 != null ? num1.data : 0) + (num2 != null ? num2.data : 0);
      carry = (sum >= 10) ? 1 : 0;
      sum = sum % 10;
      tempNode = new SinglyLinkedListNode();
      tempNode.data = sum;
      if (resultNode == null) {
        resultNode = tempNode;
      } else {
        prevNode.next = tempNode;
      }
      prevNode = tempNode;
      if (num1 != null) {
        num1 = num1.next;
      }
      if (num2 != null) {
        num2 = num2.next;
      }
    }
    if (carry > 0) {
      tempNode.next = new SinglyLinkedListNode();
      tempNode.next.data = carry;
    }
  }

  public static boolean isValidSymbolPattern(String pattern) {
    Stack<Character> patternStack = new Stack<Character>();
    if (pattern == null || pattern.isEmpty()) {
      return true;
    }
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == ')') {
        if (!patternStack.isEmpty() && patternStack.peek() == '(') {
          patternStack.pop();
        } else {
          return false;
        }
      } else if (pattern.charAt(i) == ']') {
        if (!patternStack.isEmpty() && patternStack.peek() == '[') {
          patternStack.pop();
        } else {
          return false;
        }
      } else if (pattern.charAt(i) == '}') {
        if (!patternStack.isEmpty() && patternStack.peek() == '{') {
          patternStack.pop();
        } else {
          return false;
        }
      } else {
        patternStack.push(pattern.charAt(i));
      }
    }

    if (patternStack.isEmpty()) {
      return true;
    }
    return false;
  }


  static String reduce(String path) {

    Stack<String> st = new Stack<String>();
    String res = "/";
    int pathLen = path.length();
    for (int i = 0; i < pathLen; i++) {
      String dir = "";
      while (i < pathLen && path.charAt(i) == '/')
        i++;
      while (i < pathLen && path.charAt(i) != '/') {
        dir += path.charAt(i);
        i++;
      }
      if (dir.equals("..")) {
        if (!st.empty())
          st.pop();

      } else if (dir.equals("."))
        continue;
      else if (dir.length() != 0)
        st.push(dir);
    }
    Stack<String> st1 = new Stack<String>();
    while (!st.empty()) {
      st1.push(st.pop());
    }

    while (!st1.empty()) {
      if (st1.size() != 1)
        res += (st1.pop() + "/");
      else
        res += st1.pop();
    }
    return res;
  }

  static class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
  }

  public static void main(String[] args) {
    CiscoHackerRank.getSum(10);


    CiscoHackerRank.addTwoNumbers(null, null);

    System.out.println(CiscoHackerRank.reduce("/x/./y/../z/"));

  }
}
