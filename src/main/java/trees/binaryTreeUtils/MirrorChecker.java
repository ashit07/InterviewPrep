package trees.binaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import trees.BinaryTreeNode;

public class MirrorChecker {

  public static boolean isMirrorRecursion(BinaryTreeNode node1, BinaryTreeNode node2) {

    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }

    return (node1.getData() == node2.getData())
        && isMirrorRecursion(node1.getLeft(), node2.getRight())
        && isMirrorRecursion(node1.getRight(), node2.getLeft());
  }

  public static boolean isMirrorIterative(BinaryTreeNode node1, BinaryTreeNode node2) {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(node1);
    queue.add(node2);

    while (!queue.isEmpty()) {
      BinaryTreeNode temp1 = queue.poll();
      BinaryTreeNode temp2 = queue.poll();

      if (temp1.getData() != temp2.getData()) {
        return false;
      }
      if (temp1.getLeft() != null && temp2.getRight() != null) {
        queue.add(temp1.getLeft());
        queue.add(temp2.getRight());
      } else if (temp1.getLeft() != null || temp2.getRight() != null) {
        return false;
      }
      if (temp1.getRight() != null && temp2.getLeft() != null) {
        queue.add(temp1.getRight());
        queue.add(temp2.getLeft());
      } else if (temp1.getRight() != null && temp2.getLeft() != null) {
        return false;
      }

    }
    return true;
  }


  public static void main(String[] args) {
    BinaryTreeNode tree_level = new BinaryTreeNode(1);
    tree_level.setLeft(new BinaryTreeNode(2));
    tree_level.setRight(new BinaryTreeNode(3));
    tree_level.getLeft().setLeft(new BinaryTreeNode(4));
    tree_level.getLeft().setRight(new BinaryTreeNode(5));


    BinaryTreeNode tree_level2 = new BinaryTreeNode(1);
    tree_level2.setRight(new BinaryTreeNode(2));
    tree_level2.setLeft(new BinaryTreeNode(3));
    tree_level2.getRight().setRight(new BinaryTreeNode(4));
    tree_level2.getRight().setLeft(new BinaryTreeNode(5));

    System.out.println(isMirrorIterative(tree_level, tree_level2));
  }
}
