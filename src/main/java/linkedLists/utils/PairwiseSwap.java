package linkedLists.utils;

import linkedLists.LinkedList;
import linkedLists.ListNode;
import linkedLists.Utility;

public class PairwiseSwap {

  public static ListNode pairwiseSwapIterative(ListNode node) {
    ListNode prev = node;
    ListNode curr = node.getNext();
    node = curr;
    while (true) {
      ListNode futureNode = curr.getNext();
      curr.setNext(prev);
      if (futureNode == null || futureNode.getNext() == null) {
        prev.setNext(futureNode);
        break;
      }
      prev.setNext(futureNode.getNext());

      prev = futureNode;
      curr = futureNode.getNext();
    }
    return node;
  }

  public static ListNode pairwiseSwapRecursive(ListNode node) {
    if (node == null || node.getNext() == null) {
      return node;
    }
    ListNode future = node.getNext().getNext();
    ListNode newHead = node.getNext();

    node.getNext().setNext(node);
    node.setNext(pairwiseSwapRecursive(future));

    return newHead;

  }

  public static void main(String[] args) {
    LinkedList list = Utility.getDummylinkedList();
    ListNode node = pairwiseSwapIterative(list.getHead());
    Utility.displayLinkedList(node);

    LinkedList list2 = Utility.getDummylinkedList();
    ListNode node2 = pairwiseSwapRecursive(list2.getHead());
    Utility.displayLinkedList(node2);

  }
}
