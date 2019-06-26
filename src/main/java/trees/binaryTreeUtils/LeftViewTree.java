package trees.binaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import trees.BinaryTreeNode;

public class LeftViewTree {
  private static int max_level = 0;

  public static void printLeftTreeRecursive(BinaryTreeNode node, int level) {
    if (node == null) {
      return;
    }
    if (max_level < level) {
      System.out.print(node.getData() + " ");
      max_level = level;
    }
    printLeftTreeRecursive(node.getLeft(), level + 1);
    printLeftTreeRecursive(node.getRight(), level + 1);
  }

  public static void printLeftTreeIterative(BinaryTreeNode node) {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      int i = 0;
      int size = queue.size();
      while (i++ < size) {
        BinaryTreeNode temp = queue.poll();
        if (i == 1) {
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
    printLeftTreeRecursive(node, 1);
    System.out.println("");
    printLeftTreeIterative(node);
  }
}
