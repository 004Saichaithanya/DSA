class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int second = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < second)
                return true;
            if (stk.isEmpty()) {
                stk.push(nums[i]);
            } else {
                while (!stk.isEmpty() && nums[i] > stk.peek()) {
                    second = stk.pop();
                }
                stk.push(nums[i]);

            }
        }

        return false;
    }
}