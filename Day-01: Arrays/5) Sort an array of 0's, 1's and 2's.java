class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int mid = 0;
        int right = n - 1;
        while(mid <= right)
        {
            if(nums[mid] == 0)
            {
                swap(nums, left++, mid++);
            }
            else if (nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                swap(nums, mid, right--);
            }
        }
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
