package trees.binaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import trees.BinaryTreeNode;

public class RightViewTree {
  private static int maxLevel = 0;

  public static void printRightViewrecursive(BinaryTreeNode node, int level) {
    if (node == null) {
      return;
    }
    if (maxLevel < level) {
      System.out.print(node.getData() + " ");
      maxLevel = level;
    }
    printRightViewrecursive(node.getRight(), level + 1);
    printRightViewrecursive(node.getLeft(), level + 1);
  }

  public static void printRightViewIterative(BinaryTreeNode node) {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        BinaryTreeNode temp = queue.poll();
        if (i == size) {
          System.out.print(temp.getData() + " ");
        }
        if (temp.getLeft() != null) {
          queue.add(temp.getLeft());
        }
        if (temp.getRight() != null) {
          queue.add(temp.getRight());
        }
      }
    }
  }

  public static void main(String[] args) {
    BinaryTreeNode node = BinaryTreeUtil.getDummyBinaryTree();
    printRightViewrecursive(node, 1);
    System.out.println("");
    printRightViewIterative(node);
  }
}
