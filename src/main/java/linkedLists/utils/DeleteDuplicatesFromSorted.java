package linkedLists.utils;

import linkedLists.ListNode;

public class DeleteDuplicatesFromSorted {

  public static void deleteDupsIterative(ListNode node) {

    while (node != null) {
      ListNode temp = node;

      while (temp.getData() == temp.getNext().getData()) {
        temp.setNext(temp.getNext().getNext());
      }
      node.setNext(temp);
      node = node.getNext();
    }
  }

  public static ListNode deleteDupsRecursive(ListNode node) {
    if (node == null) {
      return null;
    }
    if (node.getNext() != null) {
      return node;
    }
    ListNode temp = node;
    if (temp.getData() == temp.getNext().getData()) {
      temp.setNext(temp.getNext());
      return deleteDupsRecursive(node.getNext());
    } else {
      return deleteDupsRecursive(node.getNext());
    }
  }

}
