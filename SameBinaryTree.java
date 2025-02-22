//Neetcode 150
// Same Binary Tree
// Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
// Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.


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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if( p == null && q == null )
            return true;
        
        if( p == null || q == null )
            return false;
        
        if( p.val != q.val )
            return false;
        
        boolean leftCheck = isSameTree(p.left, q.left);

        if( !leftCheck )
            return false;
        
        boolean rightCheck = isSameTree(p.right, q.right);

        if( !rightCheck )
            return false;
        
        return true;
        
    }
}
