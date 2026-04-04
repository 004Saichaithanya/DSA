class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0; // points to last merged interval

        for (int i = 1; i < n; i++) {
            // overlap
            if (intervals[i][0] <= intervals[idx][1]) {
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
            } else {
                // no overlap → move forward
                idx++;
                intervals[idx] = intervals[i];
            }
        }

        // create result array of size idx+1
        int[][] ans = new int[idx + 1][];
        for (int i = 0; i <= idx; i++) {
            ans[i] = intervals[i];
        }

        return ans;
    }
}