class Solution {
    public int matrixSum(int[][] nums) {

        int n = nums.length;
        int m = nums[0].length;

        int score = 0;

        for (int[] num : nums)
            Arrays.sort(num);

        for (int j = 0; j < m; j++) {
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                pq.offer(nums[i][j]);
            }
            int maxEle = pq.poll();
            // System.out.println(maxEle);
            score += maxEle;
        }

        return score;
    }
}