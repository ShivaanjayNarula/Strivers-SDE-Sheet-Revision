class Solution {
    public boolean flag = false;
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public void helper(char[][] board, int row, int col)
    {
        if(flag)
        {
            return;
        }
        if(row == 9)
        {
            flag = true;
            return;
        }
        if(col == 9)
        {
            helper(board, row+1, 0);
            return;
        }
        if(board[row][col] != '.')
        {
            helper(board, row, col+1);
            return;
        }
        for(int i = 1; i <= 9; i++)
        {
            if(isSafe(board, row, col, i))
            {
                board[row][col] = (char)(i + '0');
                helper(board, row, col+1);
                if(flag)
                {
                    return;
                }
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int x)
    {
        char ch = (char)(x + '0');
        for(int i = 0; i < 9; i++)
        {
            if(board[row][i] == ch)
            {
                return false;
            }
            if(board[i][col] == ch)
            {
                return false;
            }
        }
        int start1 = row - row % 3;
        int start2 = col - col % 3;
        for(int i = start1; i < start1 + 3; i++)
        {
            for(int j = start2; j < start2 + 3; j++)
            {
                if(board[i][j] == ch)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
