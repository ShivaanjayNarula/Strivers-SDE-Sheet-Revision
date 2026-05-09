class Solution {
  public:
    int maxMeetings(vector<int>& start, vector<int>& end) {
        int n = start.size();
        vector<vector<int>> nums;
        for(int i = 0; i < n; i++)
        {
            nums.push_back({end[i], start[i], i+1});
        }
        sort(nums.begin(), nums.end());
        int last = -1;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i][1] > last)
            {
                ans++;
                last = nums[i][0];
            }
        }
        return ans;
    }
};
