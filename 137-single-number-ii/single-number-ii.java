class Solution {
    public int singleNumber(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bitIndex)) != 0)
                    cnt++;
            }
            if (cnt % 3 != 0)
                ans = ans | (1 << bitIndex);
        }
        return ans;
    }
}