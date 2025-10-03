class Solution {

    int[][] directions = { {0,1}, {1,0}, {-1,0}, {0,-1} };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] atl = new int[rows][cols]; 
        int[][] pac = new int[rows][cols];

        for(int c = 0 ; c < cols ; c++){
            dfs(0, c, pac, heights);
            dfs(rows-1, c, atl, heights);
        }

        for(int r = 0 ; r < rows ; r++){
            dfs(r, 0, pac, heights);
            dfs(r, cols-1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0 ; r < rows ; r++){
            
            for( int c = 0 ; c < cols ; c++){ 
                
                if(atl[r][c] == 1 && pac[r][c] == 1){
                    res.add(List.of(r,c));
                }

            }

        }

        return res;

    }

    public void dfs(int r, int c, int[][] ocean, int[][] heights){

        ocean[r][c] = 1;

        for(int[] dir: directions){

            int nr = r + dir[0];
            int nc = c + dir[1];

            if( nr >= 0 && nr < ocean.length && nc >=0 && nc < ocean[0].length && ocean[nr][nc] == 0 && heights[nr][nc] >= heights[r][c] ){
                dfs(nr, nc, ocean, heights);
            }

        }

        return;

    }

}
