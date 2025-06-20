class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int check = n/3;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> it : mp.entrySet())
        {
            int count = it.getValue();
            if(count > check)
            {
                ans.add(it.getKey());
            }
        }
        return ans;
    }
}
