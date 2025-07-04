// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        List<Integer> ans = new ArrayList<>();
        helper(0, 0, arr, ans);
        return ans;
    }
    public void helper(int index, int sum, int[] nums, List<Integer> ans)
    {
        if(index == nums.length)
        {
            ans.add(sum);
            return;
        }
        helper(index + 1, sum + nums[index], nums, ans);
        helper(index + 1, sum, nums, ans);
    }
}
