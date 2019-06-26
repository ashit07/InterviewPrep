package trees.traversals;

import trees.BinaryTreeNode;
import trees.binaryTreeUtils.BinaryTreeHeight;
import trees.binaryTreeUtils.BinaryTreeUtil;

public class TreeTraversalSpiralForm {

  public static void printSpiralForm(BinaryTreeNode node) {
    int height = BinaryTreeHeight.getHeight(node);
    boolean ltr = false;
    for (int i = 1; i <= height; i++) {
      printGivenLevel(node, i, ltr);
      ltr = !ltr;
    }
    System.out.println("");
  }

  public static void printGivenLevel(BinaryTreeNode node, int level, boolean ltr) {
    if (node == null) {
      return;
    }
    if (level == 1) {
      System.out.print(node.getData() + " ");
    }
    if (ltr) {
      printGivenLevel(node.getLeft(), level - 1, ltr);
      printGivenLevel(node.getRight(), level - 1, ltr);
    } else {
      printGivenLevel(node.getRight(), level - 1, ltr);
      printGivenLevel(node.getLeft(), level - 1, ltr);
    }
  }

  public static void main(String[] args) {
    BinaryTreeNode node = BinaryTreeUtil.getDummyBinaryTree();
    printSpiralForm(node);
  }
}
