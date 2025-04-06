// You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
// Return the number of distinct ways to climb to the top of the staircase.

class Solution {
    public int climbStairs(int n) {

        if(n == 1)
            return 1;

        int[] ways = new int[n+1];

        Arrays.fill(ways, 0);

        ways[1] = 1;
        ways[2] = 2;

        for( int i = 3; i <= n ; i++ ){
            // can climb +2 from 2 steps down (same n.o of ways)
            //can climb + 1 from 1 step down (same n.o of ways)
            ways[i] = ways[i-2] + ways [i-1];
        }

        return ways[n];
      
    }
}
