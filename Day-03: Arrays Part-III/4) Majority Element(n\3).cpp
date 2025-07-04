class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        int check = n/3;
        unordered_map<int, int> mp;
        for(int i = 0; i < n; i++)
        {
            mp[nums[i]]++;
        }
        vector<int> ans;
        for(auto i : mp)
        {
            int add = i.first;
            int count = i.second;
            if(count > check)
            {
                ans.push_back(add);
            }
        }
        return ans;
    }
};
