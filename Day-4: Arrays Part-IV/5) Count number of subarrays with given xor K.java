class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int check = 0;
        mp<Integer, Integer> mp = new Hashmp<>();
        mp.put(0, 1);
        for(int i = 0; i < n; i++)
        {
            check ^= nums[i];
            ans += mp.getOrDefault(check, 0);
            mp.put(check, mp.getOrDefault(check, 0) + 1);
        }
        return ans;
    }
}
