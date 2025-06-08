// Given an array of integers nums, find the subarray with the largest sum and return the sum.
// A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
    public int maxSubArray(int[] nums) {

        //maintain maxSum 
        int max = Integer.MIN_VALUE;

        int runningSum = 0;

        for(int num: nums){
          
            //running sum = running sum || num at index
            runningSum = Math.max(runningSum + num, num);

            max = Math.max(runningSum, max);

        }
        
        return max;
    }
}
