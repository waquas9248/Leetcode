class Solution {

    int[][] directions = { {0,1}, {1,0}, {-1,0}, {0,-1} };

    public int maxAreaOfIsland(int[][] grid) {
        
        int count = 0;

        for( int i = 0 ; i < grid.length ; i++ ){

            for( int j = 0 ; j < grid[0].length ; j++ ){

                if( grid[i][j] == 0 )
                    continue;
                
                count = Math.max( count, dfs(grid, i, j) );

            }

        }

        return count;

    }

    public int dfs(int[][] grid, int i, int j){

        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 )
            return 0;

        grid[i][j] = 0;

        int count = 1;
        
        for(int[] direction: directions){
            count += dfs(grid, i + direction[0], j + direction[1]);
        }

        return count;

    }

}
