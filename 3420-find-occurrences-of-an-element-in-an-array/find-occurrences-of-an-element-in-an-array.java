class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = queries.length;
        // Arrays.sort(queries);
        int[] ans = new int[n];
        int j = 0;
        int occur = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] != x) {
                j++;
            }
            if (j < nums.length && nums[j] == x) {
                occur++;
                map.put(occur, j);
            }
            j++;
        }

        // System.out.println(map);


        for(int i = 0; i < n; i++){
         ans[i] = map.getOrDefault(queries[i], -1);
        }

        return ans;
    }
}