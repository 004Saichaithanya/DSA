class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int qlen = queries.length;
        int n = nums.length;

        int[] pre = new int[n];

        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }

        int[] ans = new int[qlen];

        for (int i = 0; i < qlen; i++) {
            int low = 0, high = n - 1;
            int maxIndex = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pre[mid] > queries[i])
                    high = mid - 1;
                else {
                    low = mid + 1;
                    maxIndex = Math.max(maxIndex, mid);
                }
            }
            ans[i] = maxIndex + 1;
        }

        return ans;
    }
}