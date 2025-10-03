class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;

        //mark border regions
        for(int r = 0 ; r < rows ; r++){
            dfs(board, r, 0);
            dfs(board, r, cols-1);
        }

        for(int c = 0 ; c < cols ; c++){
            dfs(board, 0, c);
            dfs(board, rows-1, c);
        }

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }

                if(board[r][c] == 'M'){
                    board[r][c] = 'O';
                }
            
            }
        }

        return;

    }

    public void dfs(char[][] board, int r, int c ){
        
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O' )
            return;

        board[r][c] = 'M';

        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);

        return;

    }
}
