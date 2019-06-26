package trees.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import trees.BinaryTreeNode;

/**
 * 
 * @author junas01
 * 
 *  Tree:
 *          1
 *         / \
 *        2    3
 *       / \
 *      4   5
 *
 * Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

Breadth First or Level Order Traversal : 1 2 3 4 5
 */
public class TreeTraversalUtil {

  /**(a) Inorder (Left, Root, Right) : 4 2 5 1 3
  */
  public static void inorderTraversalRecursion(BinaryTreeNode node) {
    if (node == null) {
      return;
    }
    inorderTraversalRecursion(node.getLeft());
    System.out.println(node.getData());
    inorderTraversalRecursion(node.getRight());
  }

  /**(b) Preorder (Root, Left, Right) : 1 2 4 5 3
  */
  public static void preorderTraversalRecursion(BinaryTreeNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.getData() + ",");
    preorderTraversalRecursion(node.getLeft());
    preorderTraversalRecursion(node.getRight());
  }

  /** Postorder (Left, Right, Root) : 4 5 2 3 1
  */
  public static void postorderTraversalRecursion(BinaryTreeNode node) {
    if (node == null) {
      return;
    }
    postorderTraversalRecursion(node.getLeft());
    postorderTraversalRecursion(node.getRight());
    System.out.println(node.getData());
  }

  public static List<Integer> levelOrderTraversal(BinaryTreeNode node) {
    List<Integer> result = new LinkedList<>();
    Queue<BinaryTreeNode> q = new LinkedList<>();
    q.offer(node);
    while (!q.isEmpty()) {
      BinaryTreeNode root = q.poll();
      if (root != null) {
        System.out.print(root.getData() + ",");
        result.add(root.getData());
      }
      if (root.getLeft() != null) {
        q.offer(root.getLeft());
      }
      if (root.getRight() != null) {
        q.offer(root.getRight());
      }
    }
    System.out.println("");
    return result;
  }

  //(a) Inorder (Left, Root, Right) : 4 2 5 1 3
  public static List<Integer> inOrderTraversalIterative(BinaryTreeNode node) {
    System.out.println("");
    List<Integer> result = new LinkedList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    BinaryTreeNode curr = node;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.getLeft();
      }
      curr = stack.pop();
      System.out.print(curr.getData() + ",");
      result.add(curr.getData());
      curr = curr.getRight();
    }
    return result;
  }

  //(a) Preorder (Left, Root, Right) :  1 2 4 5 3
  public static List<Integer> preOrderTraversalIterative(BinaryTreeNode node) {
    System.out.println("");
    List<Integer> result = new LinkedList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()) {
      BinaryTreeNode root = stack.pop();
      result.add(root.getData());
      System.out.print(root.getData() + ",");
      if (root.getRight() != null) {
        stack.push(root.getRight());
      }
      if (root.getLeft() != null) {
        stack.push(root.getLeft());
      }
    }
    return result;
  }

  public static void main(String[] args) {
    BinaryTreeNode tree_level = new BinaryTreeNode(1);
    tree_level.setLeft(new BinaryTreeNode(2));
    tree_level.setRight(new BinaryTreeNode(3));
    tree_level.getLeft().setLeft(new BinaryTreeNode(4));
    tree_level.getLeft().setRight(new BinaryTreeNode(5));

    //   levelOrderTraversal(tree_level);
    //  preorderTraversalRecursion(tree_level);

    inOrderTraversalIterative(tree_level);

    preOrderTraversalIterative(tree_level);
  }
}


