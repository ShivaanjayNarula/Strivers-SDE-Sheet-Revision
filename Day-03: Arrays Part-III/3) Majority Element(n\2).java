class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int check = 1;
        int n = nums.length;
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
}
