class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int ans = nums[0];
        int check = 1;
        for(int i = 1; i < n; i++)
        {
            if(nums[i] == ans)
            {
                check++;
            }
            else
            {
                check--;
                if(check == 0)
                {
                    ans = nums[i];
                    check++;
                }
            }
        }
        return ans;
    }
};
