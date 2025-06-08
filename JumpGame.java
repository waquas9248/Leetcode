// You are given an integer array nums where each element nums[i] indicates your maximum jump length at that position.
// Return true if you can reach the last index starting from index 0, or false otherwise.

class Solution {
    public boolean canJump(int[] nums) {

    //aim to find the max i + nums[i] -> range to look as far as possible

    int currEnd = nums[0];

    int nextEnd = currEnd;

    int i = 0;

    while( i < nums.length ){

        if( currEnd > nums.length- 1 )
            return true;

        while( i <= currEnd ){
            nextEnd = Math.max(nextEnd, i + nums[i]);

            i++;
        }

        if( currEnd == nextEnd && nextEnd < nums.length-1 )
            return false;
        else if ( currEnd == nextEnd && nextEnd > nums.length-1 )
            return true;
        else{

            if(nextEnd > nums.length - 1)
                return true;

            currEnd = nextEnd;

        }

    }

    return true;

    }
}
