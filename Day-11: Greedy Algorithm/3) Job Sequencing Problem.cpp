class Solution {
  public:
    vector<int> jobSequencing(vector<int> &deadline, vector<int> &profit) {
        // code here
        int n = deadline.size();
        vector<vector<int>> nums;
        int maxDeadline = 0;
        for(int i = 0; i < n; i++)
        {
            nums.push_back({deadline[i], profit[i]});
            maxDeadline = max(maxDeadline, deadline[i]);
        }
        sort(nums.begin(), nums.end(), [&](vector<int> &a, vector<int> &b){
            if(a[1] == b[1])
            {
                return a[0] < b[0];
            }
            return a[1] > b[1];
        });
        int countJobs = 0;
        int totalProfit = 0;
        vector<int> slots(maxDeadline+1, 0);
        for(int i = 0; i < n; i++)
        {
            int currentDeadline = nums[i][0];
            int currentProfit = nums[i][1];
            for(int j = currentDeadline; j > 0; j--)
            {
                if(slots[j] == 0)
                {
                    slots[j] = 1;
                    countJobs++;
                    totalProfit += currentProfit;
                    break;
                }
            }
        }
        return {countJobs, totalProfit};
    }
};
