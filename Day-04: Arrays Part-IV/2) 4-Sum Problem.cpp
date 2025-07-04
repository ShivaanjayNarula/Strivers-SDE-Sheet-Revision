class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        set<vector<int>> st;
        for(int i = 0; i < n; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            for(int j = i + 1; j < n; j++)
            {
                if(j != (i + 1) && nums[j] == nums[j - 1])
                {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while(k < l)
                {
                    long long sum = nums[i];
                    sum = sum + nums[j];
                    sum = sum + nums[k];
                    sum = sum + nums[l];
                    if(sum == target)
                    {
                        vector<int> temp = {nums[i], nums[j], nums[k], nums[l]};
                        sort(temp.begin(), temp.end());
                        st.insert(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k - 1])
                        {
                            k++;
                        }
                        while(k < l && nums[l] == nums[l + 1])
                        {
                            l--;
                        }
                    }
                    else if(sum < target)
                    {
                        k++;
                    }
                    else
                    {
                        l--;
                    }
                }
            }
        }
        vector<vector<int>> ans(st.begin(), st.end());
        return ans;
    }
};
