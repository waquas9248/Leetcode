// Neetcode 150

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // have 9 sets persist until end for each column

        List<Set> columns = new ArrayList<Set>();

        for(int i = 0 ; i < board.length ; i++){
            columns.add(new HashSet<Character>());
        }

        List<Set> rows = new ArrayList<Set>();
        
        List<Set> grids = new ArrayList<Set>();

        for(int i = 0 ; i < 3 ; i++){
            rows.add(new HashSet<Character>());
            grids.add(new HashSet<Character>());
        }

        int iter = 0;

        int i = 0;

        while ( iter < 3 ){
                       
            while( i < (iter+1)*3 ){

                int j = 0;

                while( j < 9 ){
                    
                    char c = board[i][j];

                    if( c == '.' ){
                        j++;
                        continue;
                    }

                    boolean notInGrid = grids.get( j / 3 ).add(c);
                    
                    if( !notInGrid )
                        return false;
                    
                    boolean notInRow = rows.get( i % 3 ).add(c);
                    
                    if( !notInRow ) 
                        return false;

                    boolean notInColumn = columns.get( j ).add(c);

                    if( !notInColumn ) 
                        return false;
                // three 3x3 hashmaps/sets

                // three single row hashmaps/sets
                    j++;
                }
                    //renew rows and grids
                i++;
            }

            for(int k = 0 ; k < 3 ; k++){
                rows.get(k).clear();
                grids.get(k).clear();
            }

            iter++;
        }


        return true;
    }
}
