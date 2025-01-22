// Neetcode 150

// Given an array of integers numbers that is sorted in non-decreasing order.
// Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
// There will always be exactly one valid solution.
// Your solution must use O(1) additional space.

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int[] indices = new int[2];

        while ( i < j ){
            int sum = numbers[i] + numbers[j];

            if ( sum > target ){
                j--;
                continue;
            }else if ( sum < target ){
                i++;
                continue;
            }else{
                indices[0] = i+1;
                indices[1] = j+1;
                return indices;
            }
        }
        return indices;   
    }
}
