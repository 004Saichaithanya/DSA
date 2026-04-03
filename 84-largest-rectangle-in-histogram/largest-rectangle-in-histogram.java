class Solution {
    public int largestRectangleArea(int[] heights) {

        int[] nse = nseFunc(heights);
        int[] pse = pseFunc(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }

        return maxArea;

    }

    int[] nseFunc(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) {
                stk.pop();
            }
            nse[i] = stk.isEmpty() ? n : stk.peek();

            stk.push(i);
        }

        return nse;
    }

    int[] pseFunc(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) {
                stk.pop();
            }

            pse[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(i);
        }

        return pse;

    }

}