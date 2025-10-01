class Solution {
    public int orangesRotting(int[][] grid) {

        LinkedList<int[]> queue = new LinkedList<>();
        int[][] directions = { {0,1},{1,0},{-1,0},{0,-1}  };

       //count frsh fruits
        int fresh = 0;

        for(int i = 0 ; i < grid.length ; i++ ){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }

                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if( fresh == 0 )
            return 0;

        int changes = 0;

        LinkedList<int[]> temp = new LinkedList<>(queue);

        int mins = 0;

        while( ! temp.isEmpty() ){
            
            temp = new LinkedList<>();

            while( !queue.isEmpty() ){

                int[] index = queue.removeFirst();

                int r = index[0];
                int c = index[1];
                
                for(int[] direction: directions){
                    
                    int i = r + direction[0];
                    int j = c + direction[1];

                    if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 )
                        continue;

                    grid[i][j] = 2;

                    temp.add(new int[]{i,j});

                    changes++;

                }
            
            }

            if( !temp.isEmpty() )
                mins++;

            queue = new LinkedList<>(temp);

        }



       //tally changes vs fresh fruits to print -1 if not match 
       if( changes != fresh ){
            return -1;
       }

       return mins;

    }
}
