class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxVal = -1;

        for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
             
            if (set.contains(nums[i]) && set.contains(-nums[i])) {
                maxVal = Math.max(maxVal, Math.abs(nums[i]));
            }
        }
        //System.out.println(set);

        return maxVal;
    }
}