//Neetcode 150
//Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x
//Given the root of a binary tree root, return the number of good nodes within the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public int goodNodes(TreeNode root) {
      
        if( root == null )
            return 0;

        int totalLeft = recurseTree(root.left, root.val, 1);
        int totalRight = recurseTree(root.right, root.val, totalLeft);

        return totalRight;        
    }

    //store max and count as stack vars, push down the tree, updated when good node found
    public int recurseTree(TreeNode node, int max, int count){

        if( node == null )
            return count;

        if( node.val >= max ){
            max = node.val;
            count += 1;
        }
            
        int totalLeft = recurseTree(node.left, max, count);

        int totalRight = recurseTree(node.right, max, totalLeft);

        return totalRight;

    }

}

    
