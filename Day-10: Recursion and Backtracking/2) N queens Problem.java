class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            board.add(".".repeat(n));
        }
        solve(board, 0);
        return ans;
    }
    public void solve(List<String> board, int row)
    {
        int n = board.size();
        if(row == n)
        {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0; col < n; col++)
        {
            if(isSafe(board, row, col))
            {
                String str = board.get(row).substring(0, col) + 'Q' + board.get(row).substring(col+1);
                board.set(row, str);
                solve(board, row + 1);
                str = board.get(row).substring(0, col) + '.' + board.get(row).substring(col+1);
                board.set(row, str);
            }
        }
    }
    public boolean isSafe(List<String> board, int row, int col)
    {
        int n = board.size();
        for(int i = 0; i < n; i++)
        {
            if(board.get(i).charAt(col) == 'Q')
            {
                return false;
            }
        }
        for(int i = 1; row - i >= 0 && col - i >= 0; i++)
        {
            if(board.get(row - i).charAt(col - i) == 'Q')
            {
                return false;
            }
        }
        for(int i = 1; row - i >= 0 && col + i < n; i++)
        {
            if(board.get(row - i).charAt(col + i) == 'Q')
            {
                return false;
            }
        }
        return true;
    }
}
