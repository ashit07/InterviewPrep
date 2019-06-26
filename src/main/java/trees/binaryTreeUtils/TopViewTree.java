package trees.binaryTreeUtils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import trees.BinaryTreeNode;

/**
 * We do a Level order traversal and maintain horizontal distance (similar to Vertical order traversal).
 * The first one of every horizontal distance value will be the top view.
 * 
 */
public class TopViewTree {

  public static void printTopViewRecursive(BinaryTreeNode node, int hd,
      Map<Integer, BinaryTreeNode> map) {
    if (node == null) {
      return;
    }
    if (!map.containsKey(hd)) {
      map.put(hd, node);
    }
    printTopViewRecursive(node.getLeft(), hd - 1, map);
    printTopViewRecursive(node.getRight(), hd + 1, map);
  }

  public static void printTopViewRecursive(BinaryTreeNode node) {
    int hd = 0;
    //Use tree map if the order of view has to be maintained.
    //Left most node will be the one with lowest value as it is negative.
    Map<Integer, BinaryTreeNode> map = new TreeMap<>();
    printTopViewRecursive(node, hd, map);
    printMap(map);
  }

  private static void printMap(Map<Integer, BinaryTreeNode> map) {
    Set<Integer> keys = map.keySet();
    for (Integer i : keys) {
      System.out.print(map.get(i).getData() + " ");
    }
  }

  public static void printTopViewIterative(BinaryTreeNode node) {
    Queue<NodeAndHd> queue = new LinkedList<>();
    Map<Integer, BinaryTreeNode> map = new LinkedHashMap<>();
    queue.add(new NodeAndHd(node, 0));
    while (!queue.isEmpty()) {
      NodeAndHd curr = queue.poll();
      if (!map.containsKey(curr.hd)) {
        map.put(curr.hd, curr.node);
      }
      if (curr.node.getLeft() != null) {
        NodeAndHd leftNode = new NodeAndHd(curr.node.getLeft(), curr.hd - 1);
        queue.add(leftNode);
      }
      if (curr.node.getRight() != null) {
        NodeAndHd rightNode = new NodeAndHd(curr.node.getRight(), curr.hd + 1);
        queue.add(rightNode);
      }
    }
    printMap(map);

  }

  static class NodeAndHd {
    BinaryTreeNode node;
    int hd;

    public NodeAndHd(BinaryTreeNode node, int hd) {
      super();
      this.node = node;
      this.hd = hd;
    }

    public BinaryTreeNode getNode() {
      return node;
    }

    public void setNode(BinaryTreeNode node) {
      this.node = node;
    }

    public int getHd() {
      return hd;
    }

    public void setHd(int hd) {
      this.hd = hd;
    }

  }


  public static void main(String[] args) {
    BinaryTreeNode node = BinaryTreeUtil.getDummyBinaryTree();
    printTopViewRecursive(node);
    System.out.println("");
    printTopViewIterative(node);
  }
}
