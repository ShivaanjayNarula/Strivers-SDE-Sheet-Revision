class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> nums;
        for(int i = 1; i <= n; i++)
        {
            nums.push_back(i);
        }
        string ans = "";
        vector<int> fact(n, 1);
        for(int i = 1; i < n; i++)
        {
            fact[i] = fact[i-1] * i;
        }
        k--;
        for(int i = 0; i < n; i++)
        {
            int id = k / fact[n-i-1];
            ans += to_string(nums[id]);
            nums.erase(nums.begin() + id);
            k %= fact[n-i-1];
        }
        return ans;
    }
};
