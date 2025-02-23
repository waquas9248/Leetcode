//Neetcode 150
// Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.
// The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while( curr != null ){

            if ( (curr.val < p.val) && (curr.val < q.val) )
                curr = curr.right;
            else if ( (curr.val > p.val) && (curr.val > q.val) )
                curr = curr.left;

            //each of the other 7 combinations (  (<,>) , (<,=) , (>,<) , (>,=) , (=,=) , (=,<) , (=,>) ) leads to the divergence of paths, means curr is an ancestor
            else
                return curr;

        }

        return curr;

    }
}
