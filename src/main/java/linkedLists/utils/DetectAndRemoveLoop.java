package linkedLists.utils;

import linkedLists.ListNode;

public class DetectAndRemoveLoop {

  public static void detectAndRemoveLoop(ListNode node) {
    boolean loopFound = false;
    ListNode slowPtr = node;
    ListNode fastPtr = node;

    while (slowPtr != null && fastPtr != null && fastPtr.getNext() != null) {
      if (slowPtr == fastPtr) {
        System.out.println("Got the loop.");
        removeLoop(node, slowPtr);
        break;
      }
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
    }

  }

  public static void removeLoop(ListNode node, ListNode slowPtr) {
    int countLoopNodes = 1;
    ListNode temp1 = slowPtr;
    ListNode temp2 = slowPtr;
    while (temp1.getNext() != temp2) {
      temp1 = temp1.getNext();
      countLoopNodes++;
    }

    ListNode ptr1 = node;
    ListNode ptr2 = node;

    for (int i = 0; i < countLoopNodes; i++) {
      ptr2 = ptr2.getNext();
    }
    while (ptr1 != ptr2) {
      ptr1 = ptr1.getNext();
      ptr2 = ptr2.getNext();
    }
    while (ptr2.getNext() != ptr1) {
      ptr2 = ptr2.getNext();
    }

    ptr2.setNext(null);
  }

}
