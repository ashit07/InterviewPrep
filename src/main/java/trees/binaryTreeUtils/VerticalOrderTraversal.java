package trees.binaryTreeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import trees.BinaryTreeNode;

/**
 * 
 *
 *
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * 
 * Print a Binary Tree in Vertical Order | Set 2 (Map based Method)
Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9

We need to check the Horizontal Distances from root for all nodes. 
If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. 
The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance 
and a left edge is considered as -1 horizontal distance. 
For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
We can do preorder traversal of the given Binary Tree. 
While traversing the tree, we can recursively calculate HDs. 
We initially pass the horizontal distance as 0 for root. 
For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. 
For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1. 
For every HD value, we maintain a list of nodes in a hash map.
 Whenever we see a node in traversal, we go to the hash map entry and add the node to the hash map using HD as a key in map.
 *
 */
public class VerticalOrderTraversal {

  public static void printVerticalOrder(BinaryTreeNode node) {

    Map<Integer, List<Integer>> mappingNodes = new TreeMap<>();
    int hd = 0;
    fillVerticalOrder(node, hd, mappingNodes);

    Set<Integer> keys = mappingNodes.keySet();

    for (Integer i : keys) {
      List<Integer> nodesList = mappingNodes.get(i);
      for (Integer j : nodesList) {
        System.out.print(j + " ");
      }
      System.out.println("");
    }

  }

  public static void fillVerticalOrder(BinaryTreeNode node, int hd,
      Map<Integer, List<Integer>> mappingNodes) {
    if (node == null) {
      return;
    }
    if (mappingNodes.containsKey(hd)) {
      List<Integer> hdLevel = mappingNodes.get(hd);
      hdLevel.add(node.getData());
    } else {
      List<Integer> hdLevel = new LinkedList<>();
      hdLevel.add(node.getData());
      mappingNodes.put(hd, hdLevel);
    }
    fillVerticalOrder(node.getLeft(), hd - 1, mappingNodes);
    fillVerticalOrder(node.getRight(), hd + 1, mappingNodes);
  }

  public static void main(String[] args) {
    BinaryTreeNode m = BinaryTreeUtil.getDummyBinaryTree();
    printVerticalOrder(m);
  }

}
