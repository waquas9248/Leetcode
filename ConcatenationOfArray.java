// You are given an integer array nums of length n. Create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

// Specifically, ans is the concatenation of two nums arrays.

// Return the array ans.

class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;
        int[] res = new int[n * 2];

        for(int i = 0 ; i < nums.length ; i++){
            res[i] = nums[i];
        }

        for(int i = n ; i < res.length ; i++){
            res[i] = res[i-n];
        }

        return res;
        
    }
}
