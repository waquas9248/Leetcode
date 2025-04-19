// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.
// For example, "cat" is a subsequence of "crabt".

public class Solution {
  
    public int lengthOfLIS(int[] nums) {

        int maxLength = 1;
        
        int[] max = new int[nums.length];

        Arrays.fill(max,1);

        for( int i = nums.length - 1 ; i >= 0 ; i-- )
            for( int j = i + 1 ; j < nums.length ; j++ ){

                if( nums[i] < nums[j] ){
                    max[i] = Math.max( max[i], 1 + max[j] );
                    maxLength = Math.max( maxLength, max[i] );
                }

            }

        return maxLength;

    }

}
