//You are given an array nums of integers, which may contain duplicates. Return all possible subsets.
// The solution must not contain duplicate subsets. You may return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        HashSet<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);

        dfs( nums, set, new ArrayList<>(), 0 );

        return new ArrayList<>(set);

    }

    public void dfs( int[] nums, HashSet<List<Integer>> set, List<Integer> temp, int i ){

        if( i >= nums.length ){
            set.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(nums, set, temp, i+1);

        temp.remove(temp.size() - 1);
        dfs(nums,set,temp,i+1);

        return;

    }

}
