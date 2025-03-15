//Neetcode 150

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
// A binary search tree satisfies the following constraints:
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

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> inOrder = dfs(root, k, new ArrayList<Integer>() );

        return inOrder.get(k-1);

    }       

    public List<Integer> dfs( TreeNode node, int k, List<Integer> list ){

        if( node == null ){
            return list;
        }

        if( list.size() == k )
            return list;

        List<Integer> currList = dfs(node.left, k, list);

        currList.add(node.val);

        currList = dfs(node.right, k, currList);

        return currList;

    }

}
