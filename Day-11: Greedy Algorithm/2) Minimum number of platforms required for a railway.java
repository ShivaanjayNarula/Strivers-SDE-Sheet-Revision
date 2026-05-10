class Solution {
    public int findPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int check = 0;
        int left = 0;
        int right = 0;
        while(left < n && right < n)
        {
            if(arr[left] <= dep[right])
            {
                check++;
                left++;
            }
            else
            {
                check--;
                right++;
            }
            ans = Math.max(ans, check);
        }
        return ans;
    }
}
