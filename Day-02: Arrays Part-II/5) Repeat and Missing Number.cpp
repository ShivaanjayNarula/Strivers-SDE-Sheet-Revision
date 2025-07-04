class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> count(n*n+1, 0);
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                count[grid[i][j]]++;
            }
        }
        int missing = -1;
        int duplicate = -1;
        for(int i = 0; i < n*n+1; i++)
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
        return {duplicate, missing};
    }
};
