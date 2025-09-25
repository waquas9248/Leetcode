class Solution {

    int[][] directions = { {0,1}, {1,0}, {-1,0}, {0,-1} };
    
    public int numIslands(char[][] grid) {        
    
        int islands = 0;

        for(int i = 0 ; i < grid.length ; i++){

            for(int j = 0; j < grid[0].length ; j++){
                
                if(grid[i][j] == '0')
                    continue;

                dfs(grid,i,j);

                islands++;

            }


        }
        
        return islands;

    }

    public void dfs(char[][] grid, int i, int j){

        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' ){
            return;
        }

        grid[i][j] = '0';

        for(int[] direction: directions){
            dfs(grid, i+direction[0], j+direction[1]);
        }

        return;
    }

}
