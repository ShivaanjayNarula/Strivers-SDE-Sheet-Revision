class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int id = -1;
        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                id = i;
                break;
            }
        }
        if(id == -1)
        {
            reverse(nums, 0, n - 1);
            return;
        }
        int temp = -1;
        for(int i = n - 1; i > id; i--)
        {
            if(nums[i] > nums[id])
            {
                temp = i;
                break;
            }
        }
        swap(nums, id, temp);
        reverse(nums, id + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            swap(nums, start++, end--);
        }
    }
}
