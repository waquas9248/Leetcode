// Given an array nums containing n integers in the range [0, n] without any duplicates, return the single number in the range that is missing from nums.
// Follow-up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
  
class Solution {
    public int missingNumber(int[] nums) {

        int xor = 0;

        //xor is commutative , xor of duplicates is 0, whats left is the missing number
        for( int i = 0 ; i <= nums.length ; i++ )
            xor ^= i;

        for( int i = 0 ; i < nums.length ; i++ )
            xor ^= nums[i];
        
        return xor;        

    }
}
