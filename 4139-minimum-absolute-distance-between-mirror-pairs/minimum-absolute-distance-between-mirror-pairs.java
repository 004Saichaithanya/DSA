class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int rev = reverse(nums[i]);
            int val = map.getOrDefault(nums[i], -1);
            if (val != -1) {
                minDis = Math.min(minDis, Math.abs(i - val));
                //System.out.println(nums[i] + " " + rev + " " + Math.abs(i - map.get(rev)));
            }
            map.put(rev, i);
        }

        // System.out.println(map);

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int r = num % 10;
            rev = r + rev * 10;
            num = num / 10;
        }

        return rev;
    }
}