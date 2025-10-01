class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = { {0,1}, {1,0}, {-1,0}, {0,-1} };

        LinkedList<List<Integer>> queue = new LinkedList<>();

        for(int r = 0 ; r < rows ; r++){

            for(int c = 0; c < cols ; c++){
                
                // treasure found
                if( grid[r][c] == 0 ){
                    queue.add(List.of(r,c));
                }

            }

        }

            
        while( !queue.isEmpty() ){

            List<Integer> index = queue.removeFirst();

            for(int[] direction : dirs){
                
                int r = index.get(0) + direction[0];
                int c = index.get(1) + direction[1];

                if( r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != Integer.MAX_VALUE )
                    continue;

                grid[r][c] = grid[index.get(0)][index.get(1)] + 1;

                queue.add(List.of(r,c));

            }   

        }

        return;

    }

}
