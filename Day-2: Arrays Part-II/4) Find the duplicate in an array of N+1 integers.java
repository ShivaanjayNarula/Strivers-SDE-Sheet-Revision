class Solution {
    public int findDuplicate(int[] nums) {
        int a = nums[0];
        int b = nums[0];
        do
        {
            a = nums[a];
            b = nums[nums[b]];
        }while(a != b);
        a = nums[0];
        while(a != b)
        {
            a = nums[a];
            b = nums[b];
        }
        return a;
    }
}
