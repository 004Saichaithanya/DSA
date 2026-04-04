class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        //optimal->Kadane's Algorithm ->O(n)

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }

        return maxSum;
    }
}