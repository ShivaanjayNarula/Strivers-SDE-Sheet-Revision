class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                count[grid[i][j]]++;
            }
        }
        int missing = -1;
        int duplicate = -1;
        for(int i = 1; i <= n * n; i++)
        {
            if(count[i] == 2)
            {
                duplicate = i;
            }
            if(count[i] == 0)
            {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}
