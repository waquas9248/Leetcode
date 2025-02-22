// Neetcode 150
// Given a binary tree, return true if it is height-balanced and false otherwise.
// A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

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
    public boolean isBalanced(TreeNode root) {
        
        if( calcDepth(root,0) != -1 )
            return true;
        else
            return false;
            
    }

    public int calcDepth(TreeNode root, int depth){
        
        if( root == null )
            return depth;

        depth++;

        int left = calcDepth(root.left, depth);
        int right = calcDepth(root.right, depth);

        if( left == -1 || right == -1)
            return -1;

        if( Math.abs(left - right) > 1 )
            return -1;
        
        return Math.max(left, right);

    }
}
