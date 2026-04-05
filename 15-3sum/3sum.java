class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            List<Integer> sub;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(nums[k]);
                    ans.add(sub);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }

        }

        return ans;

    }
}