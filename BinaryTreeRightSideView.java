//Neetcode 150
// You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of the tree, ordered from top to bottom.

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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<Integer> rightVals = new ArrayList<>();

        //maintain level order of nodes with queue
        List<List<TreeNode>> nodes = new ArrayList<>();

        nodes.add(List.of(root));

        //recurse through each level - end when no nodes in a level
        while( !nodes.isEmpty() ){
            
            List<TreeNode> prevNodes = nodes.remove(0);

            List<TreeNode> currNodes = new ArrayList<>();

            int i = 0;

            while( i < prevNodes.size() ){
                
                //add each node's children

                if( prevNodes.get(i).left != null )
                    currNodes.add(prevNodes.get(i).left);

                if( prevNodes.get(i).right != null )
                    currNodes.add(prevNodes.get(i).right);
                
                i++;

            }

            //get the last node val, add to the list
            rightVals.add(prevNodes.get(i-1).val);

            if( currNodes.size() > 0 )
                nodes.add(currNodes);

        }

        return rightVals;

    }
}
