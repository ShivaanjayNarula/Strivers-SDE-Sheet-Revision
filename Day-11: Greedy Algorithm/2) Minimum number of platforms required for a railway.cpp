class Solution {
  public:
    int minPlatform(vector<int>& arr, vector<int>& dep) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        sort(dep.begin(), dep.end());
        int ans = 0;
        int check = 0   ;
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
            ans = max(ans, check);
        }
        return ans;
    }
};
