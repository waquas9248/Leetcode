// You are given a 2D array of integers triplets, where triplets[i] = [ai, bi, ci] represents the ith triplet. You are also given an array of integers target = [x, y, z] which is the triplet we want to obtain.
// To obtain target, you may apply the following operation on triplets zero or more times:
// Choose two different triplets triplets[i] and triplets[j] and update triplets[j] to become [max(ai, aj), max(bi, bj), max(ci, cj)].
// * E.g. if triplets[i] = [1, 3, 1] and triplets[j] = [2, 1, 2], triplets[j] will be updated to [max(1, 2), max(3, 1), max(1, 2)] = [2, 3, 2].
// Return true if it is possible to obtain target as an element of triplets, or false otherwise.

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean foundFirst = false;
        boolean foundSecond = false;
        boolean foundThird = false;
        
        for(int i = 0 ; i < triplets.length ; i++){

            //triplet not useful
            if( triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2] )
                continue;

            if( !foundFirst && triplets[i][0] == target[0] )
                foundFirst = true;

            if( !foundSecond && triplets[i][1] == target[1] )
                foundSecond = true;

            if( !foundThird && triplets[i][2] == target[2] )
                foundThird = true;

            if( foundFirst && foundSecond && foundThird )
                return true;

        }

        return false;

    }
}
