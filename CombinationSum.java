// You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
// The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
// You may return the combinations in any order and the order of the numbers in each combination can be in any order.

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> list = new ArrayList<>();

        dfs(nums, target, 0, 0, list, new ArrayList<>());

        return list;
    
    }

    public void dfs( int[] nums, int target, int sum, int i, List<List<Integer>> list, List<Integer> temp ){

        if( sum == target ){
            list.add( new ArrayList<>(temp) );
            return;
        }

        if( i >= nums.length || sum > target )
            return;
        
        temp.add(nums[i]);
        dfs( nums, target, sum + nums[i], i, list, temp );
        
        temp.remove(temp.size() - 1);
        dfs( nums, target, sum, i+1, list, temp );

        return;

    }

}
