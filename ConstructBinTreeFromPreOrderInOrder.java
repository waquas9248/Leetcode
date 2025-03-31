// //You are given two integer arrays preorder and inorder.
// preorder is the preorder traversal of a binary tree
// inorder is the inorder traversal of the same tree
// Both arrays are of the same size and consist of unique values.
// Rebuild the binary tree from the preorder and inorder traversals and return its root.

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

    public TreeNode buildTree( int[] preorder, int[] inorder ) {

        return constructTree( preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1 );
     
    }

    public TreeNode constructTree( int[] preorder, int[] inorder, int l1, int h1, int l2, int h2 ){
        
        TreeNode root = new TreeNode();

        root.val = preorder[l1];

        int rootIndex = findRoot( preorder, inorder, l1, h1, l2, h2 );
     
        int leftSize = rootIndex - l2;

        int rightSize = h2 - rootIndex;

        //build recursively until subtrees exist
        if( leftSize > 0 )
            root.left = constructTree( preorder, inorder, l1 + 1, l1 + leftSize, l2, rootIndex - 1 );

        if( rightSize > 0 )
            root.right = constructTree( preorder, inorder, l1 + leftSize + 1, h1, rootIndex + 1, h2 );

        return root;

    }

    public int findRoot( int[] preorder, int[] inorder, int l1, int h1, int l2, int h2 ){

        int root = preorder[l1];

        if ( l2 == h2 )
            return l2;

        for( int i = l2; i <= h2 ; i++ ){

            if( inorder[i] == root )
                return i;

        }

        return -1;

    }

}
