class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //         for (int[] in : intervals) {
        // System.out.println("[" + in[0] + "," + in[1] + "]");
        // }

        res.add(new int[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < n; i++) {
            int[] last = res.getLast();
            if (intervals[i][0] <= last[1]) {
                int cur_end = intervals[i][1];
                last[1] = Math.max(cur_end, last[1]);
            } else {
                res.add(new int[] { intervals[i][0], intervals[i][1] });
            }

        }

        // for(int[] in : res){
        //   //  System.out.println("hi");
        //     System.out.println("[" + in[0] + "," + in[1] + "]");
        // }

        int[][] ans = new int[res.size()][];

        for (int i = 0; i < ans.length; i++)
            ans[i] = res.get(i);

        return ans;
    }
}