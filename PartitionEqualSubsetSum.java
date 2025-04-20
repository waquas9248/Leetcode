// You are given an array of positive integers nums.
// Return true if you can partition the array into two subsets, subset1 and subset2 where sum(subset1) == sum(subset2). Otherwise, return false.

class Solution {
    public boolean canPartition(int[] nums) {

        // if odd sumr eturn false
        int sum = Arrays.stream(nums).sum();

        if( sum % 2 == 1 )
            return false;

        // if any num greater than half, return false
        long count = Arrays.stream(nums)
                        .filter( num -> num > sum/2 )
                        .count();

        if( count > 0 )
            return false;

        // if num equal to half is found, return true
        int target = sum / 2;
        if ( Arrays.stream(nums).anyMatch( num -> num == target) )
            return true;

        int[][] foundSum = new int[nums.length][target + 1];

        for( int[] row : foundSum ) 
            Arrays.fill(row, 0);

        foundSum[0][nums[0]] = 1;

        if ( target == nums[0] )
            return true;

        for( int i = 1 ; i < nums.length ; i++){
            
            //save all progress of sums found from 1 upto target
            for(int j = 1 ; j < target + 1 ; j++ ){    

                int check = 0;

                if( nums[i] == j ){
                    check = 1;
                }else if( nums[i] < j ){
                    check = Math.max( foundSum[i-1][j - nums[i]], foundSum[i-1][j] );
                }else{
                    check = foundSum[i-1][j];
                }

                foundSum[i][j] = check;
                
                // Debug with line below:
                // System.out.println( "for: " + nums[i] + " " + "target: " + j + " " + "check: " + foundSum[i][j] );

            }

            if( foundSum[i][target] == 1)   
                return true;

        } 

        return false;

    }
}
