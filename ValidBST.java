//Neetcode 150
//Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
// A valid binary search tree satisfies the following constraints:
// The left subtree of every node contains only nodes with keys less than the node's key.
// The right subtree of every node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees are also binary search trees.


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
    public boolean isValidBST(TreeNode root) {

        return check(Integer.MIN_VALUE, root, Integer.MAX_VALUE);

    }

    public boolean check( int lowerLimit, TreeNode node, int upperLimit ){

        if( node == null )
            return true;
        
        if( node.val <= lowerLimit )
            return false;
        
        if( node.val >= upperLimit )
            return false;

        boolean leftCheck = check( lowerLimit, node.left, node.val );

        if( leftCheck == false )
            return false;
        
        boolean rightCheck = check( node.val , node.right , upperLimit );

        if( rightCheck == false )
            return false;
        
        return true;

    }

}


