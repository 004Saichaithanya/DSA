class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans=new ArrayList<>();

        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int key : map.keySet()) {
            if (map.get(key) > Math.floor(n / 3))
                ans.add(key);
        }

        return ans;
    }
}