class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] pos = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y)) {
                pos[0] = i;
                pos[1] = map.get(y);
                break;
            }
            map.put(nums[i], i);
        }

        return pos;
    }
}