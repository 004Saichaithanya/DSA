class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (List<Integer> val : map.values()) {
            int s = val.size();
            if (s > 1) {
                long[] preSum = getPrefixSum(val);
                long total = preSum[s-1];
                long left = 0, right = 0;
                for (int i = 0; i < s; i++) {
                    int x = val.get(i);
                    left = (i == 0) ? 0 : ( (long)i * x - (preSum[i - 1]));
                    right = (i == s - 1) ? 0 : ((total - preSum[i]) - (long)(s - i - 1) * x);
                    ans[x] = left + right;

                }
            }
        }

        return ans;
    }

    long[] getPrefixSum(List<Integer> arr) {
        long[] ans = new long[arr.size()];
        ans[0] = arr.get(0);

        for (int i = 1; i < arr.size(); i++)
            ans[i] = ans[i - 1] + arr.get(i);

        return ans;
    }

    // int[] getSufSum(List<Integer> arr) {
    //     int n = arr.size();
    //     int[] ans = new int[arr.size()];
    //     ans[n - 1] = arr.get(n - 1);

    //     for (int i = n - 2; i >= 0; i--)
    //         ans[i] = ans[i + 1] + arr.get(i);

    //     return ans;
    // }
}