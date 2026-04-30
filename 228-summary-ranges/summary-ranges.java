class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        int i = 0, j = 1;
        while (i < n && j < n) {
            if (nums[j] - nums[i] == 1) {
                int first = nums[i];
                while (i < n && j < n && nums[j] - nums[i] == 1) {
                    i++;
                    j++;
                }
                int last = nums[i];
                ans.add(first + "->" + last);
            } else {
                ans.add(nums[i] + "");
            }
            i++;
            j++;
        }
        if (i < n)
            ans.add(nums[i] + "");
        // System.out.println(ans);
        return ans;
    }
}