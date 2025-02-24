//Neetcode 150
// Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        //Queue of level-wise nodes
        List<List<TreeNode>> nodes = new ArrayList<>();

        nodes.add(List.of(root));

        while( nodes.size() > 0 ){

            List<TreeNode> prevNodes = nodes.remove(0);

            int i = 0;

            List<Integer> levelVals = new ArrayList<>();

            List<TreeNode> currNodes = new ArrayList<>();

            while( i < prevNodes.size() ){
                
                levelVals.add(prevNodes.get(i).val);

                if( prevNodes.get(i).left != null )
                    currNodes.add(prevNodes.get(i).left);
                
                if( prevNodes.get(i).right != null )
                    currNodes.add(prevNodes.get(i).right);

                i++;

            }

            result.add(levelVals);

            if(currNodes.size() > 0)
                nodes.add(currNodes);

        }

        return result;
        
    }
}
