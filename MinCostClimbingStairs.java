// You are given an array of integers cost where cost[i] is the cost of taking a step from the ith floor of a staircase. After paying the cost, you can step to either the (i + 1)th floor or the (i + 2)th floor.
// You may choose to start at the index 0 or the index 1 floor.
// Return the minimum cost to reach the top of the staircase, i.e. just past the last index in cost.
  
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if ( cost.length == 2 )
            return Math.min( cost[0], cost[1] );

        for( int i = 2 ; i < cost.length ; i++ )
            cost[i] = Math.min( cost[i-2], cost[i-1] ) + cost[i];
        
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        
    }
}
