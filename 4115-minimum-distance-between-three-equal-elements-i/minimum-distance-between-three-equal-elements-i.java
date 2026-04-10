class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        if (n == 1)
            return -1;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            else
                map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        for (List<Integer> L : map.values()) {
            if (L.size() == 3) {
                int i = L.get(0);
                int j = L.get(1);
                int k = L.get(2);
                int cur = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                min = Math.min(min, cur);
            } else if (L.size() > 3) {
                for (int idx = 0; idx < L.size() - 2; idx++) {
                    int i = L.get(idx);
                    int j = L.get(idx + 1);
                    int k = L.get(idx + 2);
                    int cur = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);

                    //  System.out.println(cur);
                    min = Math.min(min, cur);
                }

            }
        }

        // System.out.println(min);
        //System.out.println(map);

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}