class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for (int[] nums : matrix) {
            int n = nums.length;
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                    return true;
                else if (nums[mid] < target)
                    low = mid + 1;
                else if (nums[mid] > target)
                    high = mid - 1;
            }
        }

        return false;
    }
}