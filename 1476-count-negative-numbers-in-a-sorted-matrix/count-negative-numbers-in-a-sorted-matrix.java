class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;

        for (int[] arr : grid) {
            int n = arr.length;
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < 0) {
                    cnt += (high - mid + 1);
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
        }

        return cnt;
    }
}