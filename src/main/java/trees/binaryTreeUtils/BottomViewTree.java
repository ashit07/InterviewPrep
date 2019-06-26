package trees.binaryTreeUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import trees.BinaryTreeNode;

public class BottomViewTree {

  public static void printBottomView(BinaryTreeNode node) {
    int hd = 0;
    Map<Integer, BinaryTreeNode> map = new TreeMap<>();
    printBottomView(node, hd, map);
    printMap(map);
  }

  private static void printBottomView(BinaryTreeNode node, int hd,
      Map<Integer, BinaryTreeNode> map) {
    if (node == null) {
      return;
    }
    map.put(hd, node);
    printBottomView(node.getLeft(), hd - 1, map);
    printBottomView(node.getRight(), hd + 1, map);
  }

  private static void printMap(Map<Integer, BinaryTreeNode> map) {
    Set<Integer> keys = map.keySet();
    for (Integer i : keys) {
      System.out.print(map.get(i).getData() + " ");
    }
  }

  private static void printBottomViewIterative(BinaryTreeNode node) {
    Map<Integer, BinaryTreeNode> map = new TreeMap<>();
    NodeAndHd curr = new NodeAndHd(node, 0);
    Queue<NodeAndHd> queue = new LinkedList<>();
    queue.add(curr);
    while (!queue.isEmpty()) {
      NodeAndHd temp = queue.poll();
      map.put(temp.hd, temp.node);
      if (temp.node.getLeft() != null) {
        queue.add(new NodeAndHd(temp.node.getLeft(), temp.hd - 1));
      }
      if (temp.node.getRight() != null) {
        queue.add(new NodeAndHd(temp.node.getRight(), temp.hd + 1));
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
    printBottomView(node);
    System.out.println("");
    printBottomViewIterative(node);
  }
}
