class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n)
            return -1;
        int low = getMin(bloomDay);
        int high = getMax(bloomDay);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            int curbqs = 0;
            for (int i = 0; i < n; i++) {
                while (i < n && bloomDay[i] <= mid) {
                    cnt++;
                    i++;
                }
                curbqs += (cnt / k);
                cnt = 0;
            }
            curbqs += (cnt / k);

            if (curbqs < m)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr)
            min = Math.min(x, min);

        return min;
    }

    int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr)
            max = Math.max(x, max);

        return max;
    }

}
