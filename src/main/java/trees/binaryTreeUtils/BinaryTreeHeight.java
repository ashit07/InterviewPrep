package trees.binaryTreeUtils;

import trees.BinaryTreeNode;

public class BinaryTreeHeight {

  public static int getHeight(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }
    int lftHeight = getHeight(node.getLeft());
    int rghtHeight = getHeight(node.getRight());
    return 1 + Math.max(lftHeight, rghtHeight);
  }

}
