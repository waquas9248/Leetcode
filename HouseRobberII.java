// You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a circle, i.e. the first house and the last house are neighbors.
// You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.
// Return the maximum amount of money you can rob without alerting the police.

class Solution {
    public int rob(int[] nums) {

        if( nums.length == 1 )
            return nums[0];
      
        // max of excluding 1st house and excluding last house
        return Math.max( robSub( Arrays.copyOfRange(nums,0,nums.length - 1) ), robSub( Arrays.copyOfRange(nums,1,nums.length) ) );
        
    }

    public int robSub( int[] nums ){

        if( nums.length == 1 )
            return nums[0];
        
        if( nums.length == 2 )
            return Math.max(nums[0], nums[1]);

        int[] money = new int[nums.length];

        money[0] = nums[0];
        money[1] = nums[1];

        for(int i = 2 ; i < nums.length ; i++)
            //add max of total until 2 houses back or total until 3 houses back
            money[i] = nums[i] + Math.max(money[i-2], money[i-1] - nums[i-1] );

        return Math.max( money[nums.length - 2], money[nums.length - 1] );

    }
}
