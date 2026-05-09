class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            meetings[i][0] = end[i];
            meetings[i][1] = start[i];
        }
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int lastEndTime = -1;
        for (int i = 0; i < n; i++)
        {
            if(meetings[i][1] > lastEndTime)
            {
                count++;
                lastEndTime = meetings[i][0];
            }
        }
        return count;
    }
}
