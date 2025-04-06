// Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.
// For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.

class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for( int i = 0 ; i < board.length ; i++ ){
            for( int j = 0 ; j < board[0].length ; j++ ){
                boolean res = dfs(board, word, visited, 0, i, j);
                if( res == true )
                    return true;
           }
        }

        return false;

    }

    public boolean dfs( char[][] board, String word, boolean[][] visited, int index, int i, int j){

        if( index >= word.length() )
            return true;
                
        if( j < 0 || j >= board[0].length || i < 0 || i >= board.length || board[i][j] != word.charAt(index) || visited[i][j] == true )
            return false;
        

        visited[i][j] = true;

        boolean res = dfs( board, word, visited, index + 1, i-1, j )  //up
                    || dfs( board, word, visited, index + 1, i+1, j )  //down
                    || dfs( board, word, visited, index + 1, i, j-1 )  //left
                    || dfs( board, word, visited, index + 1, i, j+1 ); //right

        visited[i][j] = false;

        return res;

    }

}
