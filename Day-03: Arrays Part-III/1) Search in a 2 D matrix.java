class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
        {
            return false;
        }
        int n = matrix[0].length;
        if(n == 0)
        {
            return false;
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
