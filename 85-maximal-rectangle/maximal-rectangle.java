class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n][m];
        int maxArea = 0;

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (matrix[i][j] - '0');
                if (matrix[i][j] == '0')
                    sum = 0;
                preSum[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(preSum[i]));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) {
                int ele = stk.peek();
                stk.pop();
                int pse = stk.isEmpty() ? -1 : stk.peek();
                int nse = i;
                maxArea = Math.max(maxArea, heights[ele] * (nse - pse - 1));
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            int nse = n;
            int element = stk.peek();
            stk.pop();
            int pse = stk.isEmpty() ? -1 : stk.peek();

            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));

        }

        return maxArea;
    }
}