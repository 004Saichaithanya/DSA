class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] ans = new int[n];

        prefix[0] = nums[0];
        postfix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = (i == 0 ? 1 : prefix[i - 1]) * (i == n - 1 ? 1 : postfix[i + 1]);
        }
        return ans;
    }
}