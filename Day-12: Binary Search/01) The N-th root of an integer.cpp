class Solution {
public:
    int nthRoot(int n, int m) {
        int left = 1;
        int right = m;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            long long ans = 1;
            bool overflow = false;
            for(int i = 0; i < n; i++)
            {
                if(ans > m / mid)
                {
                    overflow = true;
                    break;
                }
                ans *= mid;
            }
            if(!overflow && ans == m)
            {
                return mid;
            }
            else if(overflow || ans > m)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }
};
