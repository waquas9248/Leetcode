// Unique Paths 
// There is an m x n grid where you are allowed to move either down or to the right at any point in time.
// Given the two integers m and n, return the number of possible unique paths that can be taken from the top-left corner of the grid (grid[0][0]) to the bottom-right corner (grid[m - 1][n - 1]).
// You may assume the output will fit in a 32-bit integer.

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];
              
        paths[m-1][n-1] = 1;

        // for each cell, start from bottom right, iterate backwards
        for( int i = m-1 ; i >= 0 ; i-- ){
        
            // count ways -> right + down
            for( int j = n-1 ; j >= 0 ; j-- ){

                //right
                if( i+1 < m )
                    paths[i][j] = paths[i+1][j];

                //down
                if( j+1 < n )
                    paths[i][j] += paths[i][j+1];

            }
        
        }

        // return top left
        return paths[0][0];
    
    }
  
}
