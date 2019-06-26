package trees.binaryTreeUtils;

import trees.BinaryTreeNode;

public class BinaryTreeUtil {

  public static BinaryTreeNode getDummyBinaryTree() {
    BinaryTreeNode tree_level = new BinaryTreeNode(1);
    tree_level.setLeft(new BinaryTreeNode(2));
    tree_level.setRight(new BinaryTreeNode(3));
    tree_level.getLeft().setLeft(new BinaryTreeNode(4));
    tree_level.getLeft().setRight(new BinaryTreeNode(5));

    return tree_level;
  }
}
