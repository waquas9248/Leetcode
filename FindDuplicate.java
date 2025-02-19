//Neetcode - 150
//Find the Duplicate Number
// You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
// Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
//O(n) time and O(1) space


class Solution {
    public int findDuplicate(int[] nums) {
        
        int i = 0;
        int k = nums[0];
      
        while ( i < nums.length ){
            k = nums[i];

            //breaks when duplicate found
            if( (i != k-1) && (nums[i] == nums[k-1]) )
                return k;

            int temp = 0;

            //keep changing nums[i-1] to i until everything in place
            while( nums[k-1] != k ){                
                temp = nums[k-1];
                nums[k-1] = k;
                k = temp;
            }

            i++;
        }
        
        return k;
    }
}
