// Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        HashMap<Integer,Boolean> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){

            if ( map.getOrDefault(nums[i], false) ){
                return true;
            }else{
                map.put(nums[i],true);
            }

        }

        return false;
    }
}
