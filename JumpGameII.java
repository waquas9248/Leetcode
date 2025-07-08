// You are given an array of integers nums, where nums[i] represents the maximum length of a jump towards the right from index i. For example, if you are at nums[i], you can jump to any index i + j where:
// j <= nums[i]
// i + j < nums.length
// You are initially positioned at nums[0].
// Return the minimum number of jumps to reach the last position in the array (index nums.length - 1). You may assume there is always a valid answer.

class Solution {

    public int jump(int[] nums) {

        if( nums.length == 1 )
            return 0; 

        int maxCoverage = 0 + nums[0];
        int jump = 0;
        
        if ( maxCoverage >= nums.length - 1 )
            return jump+1;
        
        jump += 1;

        int i = 1;

        int nextMax = 0;

        while( i < nums.length ){

            while( i <= maxCoverage ){

                nextMax = Math.max( i + nums[i], nextMax );

                if ( nextMax >= nums.length - 1 )
                    return jump+1;
            
                i++;
            }

            jump += 1;

            maxCoverage = nextMax;

        }
      
        return jump;

    }

}
