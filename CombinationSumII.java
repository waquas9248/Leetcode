// You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
// Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.
// You may return the combinations in any order and the order of the numbers in each combination can be in any order.

class Solution {
  
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        HashSet<List<Integer>> set = new HashSet<>();
      
        Arrays.sort(candidates);
        
        dfs( candidates, set, new ArrayList<>(), target, 0, 0 );

        return new ArrayList<>(set);

    }

    public void dfs( int[] candidates, HashSet<List<Integer>> set, List<Integer> temp, int target, int sum, int i ){

        if( sum == target ){
            set.add( new ArrayList<>(temp) );
            return;
        }

        if( i >= candidates.length || sum > target )
            return;

        temp.add(candidates[i]);
        dfs( candidates, set, temp, target, sum + candidates[i], i + 1 );

        temp.remove(temp.size() - 1);
        dfs( candidates, set, temp, target, sum, i + 1 );
            
        return;
      
    }
  
}
