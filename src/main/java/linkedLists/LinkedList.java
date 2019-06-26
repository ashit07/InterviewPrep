package linkedLists;

/**
 * This class is an implementation of LinkedList and supports operations:
 * a) Adding an object at beginning of LinkedList
 * b) Adding an object at end of LinkedList
 * c) Adding some data at intermediate position in LinkedList
 * d) Deleting an object from beginning of LinkedList
 * e) Deleting an object from end of LinkedList
 * f) Deleting an object from intermediate position in LinkedList
 * g) Deleting data at particular position.
 * h) Getting position of an element in LinkedList
 * i) Getting length of LinkedList
 * j) Getting node with position
 * j) Clearing the list
 * 
 * @author ashi
 *
 */
public class LinkedList {
  private int length = 0;
  ListNode head;

  public LinkedList() {
    length = 0;
  }

  //Return first element of the list
  public synchronized ListNode getHead() {
    return head;
  }

  /**
   * Insertion of node at beginning.
   */
  public synchronized void insertAtBegin(ListNode node) {
    node.setNext(head);
    head = node;
    length++;
  }

  /**
   * Insert at end of node.
   * a) if list is null, new node is head.
   * b) traverse to end of list and point the lastNode to new node and 
   * 	  new node next to null 
   * @param node
   */
  public synchronized void insertAtEnd(ListNode node) {
    if (head == null) {
      head = node;
    } else {
      ListNode p, q;
      for (p = head; (q = p.getNext()) != null; p = q) {
        p.setNext(node);
      }
    }
    length++;
  }

  /**
   * Insert data at position in LinkedList
   * @param data
   * @param position
   */
  public void insert(int data, int position) {
    //fix the position
    if (position < 0) {
      position = 0;
    }
    if (position > length) {
      position = length;
    }
    //if list is empty, make it be the only element
    if (head == null) {
      head = new ListNode(data);
    }
    //if adding at front of list
    else if (position == 0) {
      ListNode temp = new ListNode(data);
      temp.setNext(head);
      head = temp;
    }
    // else find the correct position and add
    else {
      ListNode temp = head;
      for (int i = 0; i < position - 1; i++) {
        temp = temp.getNext();
      }
      ListNode newNode = new ListNode(data);
      newNode.setNext(temp.getNext());
      temp.setNext(newNode);

    }
    length++;
  }

  /**
   * Remove the head node from Linked List and returns the head
   * @return
   */
  public synchronized ListNode removeFromBegin() {
    ListNode temp = head;
    //Check if list not empty
    if (temp != null) {
      head = head.getNext();
      temp.setNext(null);
      length--;
    }
    return temp;
  }

  /**
   * Traverses the list and Removes the last node 
   * @return
   */
  public synchronized ListNode removeFromEnd() {
    //Check if list is empty
    if (head == null) {
      return null;
    }
    //p -> currentElement, q-> previousToCurrentElement
    ListNode p = head, q = null, next = head.getNext();
    //Check if only element
    if (next == null) {
      head = null;
      length--;
      return p;
    }
    //Traverse to last and remove
    while ((next = p.getNext()) != null) {
      q = p;
      p = next;
    }
    q.setNext(null);
    length--;
    return p;
  }

  /**
   * Removes the node matching the node. 
   * @param node
   * @return
   */
  public synchronized void removeMatched(ListNode node) {
    if (head == null) {
      return;
    }
    if (node.equals(head)) {
      head = head.getNext();
      return;
    }
    //p -> currentElement, q-> nextElement
    ListNode p = head, q = null;
    while ((q = p.getNext()) != null) {
      if (node.equals(p)) {
        p.setNext(q.getNext());
        return;
      }
      p = q;
    }
  }

  /**
   * Remove the value at given position.
   * If position < 0, remove the element at beg
   * If position > length, remove the last element
   * @param position
   */
  public void remove(int position) {
    if (position < 0) {
      position = 0;
    }
    if (position >= length) {
      position = length - 1;
    }
    if (head == null) {
      return;
    }
    if (position == 0) {
      head = head.getNext();
    } else {
      ListNode temp = head;
      for (int i = 0; i < position; i++) {
        temp = temp.getNext();
      }
      temp.setNext(temp.getNext().getNext());
    }
    length--;
  }

  /**
   * Returns length of list
   * @return
   */
  public int getLength() {
    return length;
  }

  /**
   * 
   * @param data
   * @return position of data in LinkedList
   */
  public int getPosition(int data) {
    ListNode temp = head;
    int position = 0;
    while (temp != null) {
      if (temp.getData() == data) {
        return position;
      }
      position++;
      temp = temp.getNext();
    }
    return Integer.MIN_VALUE;
  }

  /**
   * 
   * @param position
   * 
   * Only written this method to enforce cyclic loop. 
   * Should not be a part of regular linked list.
   * 
   * @return Node at position in LinkedList
   */
  public ListNode getNode(int position) {
    ListNode temp = head;
    if (position < 0) {
      position = 0;
      return temp;
    }
    if (position > length) {
      position = length - 1;
    }
    for (int i = 1; i < position; i++) {
      temp = temp.getNext();
    }
    return temp;

  }

  public void clearList() {
    head = null;
    length = 0;
  }

  @Override
  public String toString() {
    String result = "[head ->";
    if (head == null) {
      return result + "]";
    }


    result = result + head.getData();
    ListNode temp = head.getNext();
    while (temp != null) {
      result = result + " -> " + temp.getData();

      temp = temp.getNext();
    }
    result = result + "]";

    return result;
  }
}
