//Neetcode 150
// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if( subRoot == null)
            return true;
        
        if( root == null )
            return false;
        
        Stack<TreeNode> nodeStack = new Stack();

        nodeStack.push(root);

        //Solution could be optimized through a heuristic search algorithm to prune the search tree space
      
        while( !nodeStack.isEmpty() ){

            TreeNode node = nodeStack.pop();
          
            boolean check = checkSubness(node, subRoot);

            if( check == true )
                return true;
            
            if( node.right != null )
                nodeStack.push(node.right);
            
            if( node.left != null )
                nodeStack.push(node.left);

            
        }
        
        return false;
        
    }

    public boolean checkSubness(TreeNode root, TreeNode subRoot){
        
        if( root == null && subRoot == null )
            return true;
        
        if( root == null || subRoot == null )
            return false;

        if( root.val != subRoot.val )
            return false;

        
        boolean leftCheck = checkSubness(root.left, subRoot.left);

        if( !leftCheck )
            return false;

        boolean rightCheck = checkSubness(root.right, subRoot.right);
        
        if( !rightCheck )
            return false;
        
        return true;

    }

}

