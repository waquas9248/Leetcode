// You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.
// Return the number of distinct combinations that total up to amount. If it's impossible to make up the amount, return 0.
// You may assume that you have an unlimited number of each coin and that each value in coins is unique.

class Solution {

    int[][] ways;

    public int change(int amount, int[] coins) {

        //ways to make change using upto n coins (signifying rows) for 1...amount (signifying columns)
        ways = new int[coins.length+1][amount+1];

        int r = 0;

        //1 way to make change when balance is 0 with each coin present 
        while( r <= coins.length ){

            ways[r][0] = 1;

            r++;

        }
        
        for( int i = 1 ; i <= coins.length ; i++ ){
            
            int val = coins[i-1];

            for( int j = 1 ; j <= amount ; j++ ){
            
                if( j < val){
                    ways[i][j] = ways[i-1][j];
                    continue;
                }

                int bal = j - val;

                //number of ways to make change for balance using this coin + w/o this coin
                ways[i][j] = ways[i][bal] + ways[i-1][j];
              
            }

        }
      
        //ways to make change for amount using all coins
        return ways[coins.length][amount];

    }

}
