// You are given an array of integers nums and an integer target.
// For each number in the array, you can choose to either add or subtract it to a total sum.
// For example, if nums = [1, 2], one possible sum would be "+1-2=-1".
// If nums=[1,1], there are two different ways to sum the input numbers to get a sum of 0: "+1-1" and "-1+1".
// Return the number of different ways that you can build the expression such that the total sum equals target.
  
class Solution {

    public int[][] ways;

    public int findTargetSumWays(int[] nums, int target) {
        
        int total = Arrays.stream(nums)
                        .sum();

        //store num of ways for each possible sum-index pair path to avoid repetition 
        ways = new int[nums.length][2*total + 1];

        for( int[] arr: ways){
            Arrays.fill(arr, -1);
        }

        return recurse( 0, 0, target, nums, total );

    }

    int recurse(int sum, int i, int target, int[] nums, int total ){
        
        // base case out of bounds
        if( i >= nums.length ){
            if( sum == target )
                return 1;
            else
                return 0;
        }

        int lookup = sum;
      
        if( sum < 0 )
            lookup = total - sum;

        if( ways[i][lookup] != -1 )
            return ways[i][lookup];

        // choose to add current num
        int addWays = recurse( sum + nums[i], i+1, target, nums, total );

        //choose to sub current num
        int subWays = recurse( sum - nums[i], i+1, target, nums, total );

        ways[i][lookup] = addWays + subWays;

        return ways[i][lookup];

    }

}
