class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int n = nums.length;

        for (int end = 0; end < n; end++) {
            if (!map.containsKey(nums[end])) {
                map.put(nums[end], end);
            } else {
                if (Math.abs(map.get(nums[end]) - end) <= k)
                    return true;
                else {
                    map.put(nums[end], end);
                    start++;
                }
            }
        }

        return false;
    }
}