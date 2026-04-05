class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumAll = (n * (n + 1)) / 2;
        // System.out.println(sumAll);

        int sumArr = 0;

        for (int x : nums)
            sumArr += x;

        //   System.out.println(sumArr);

        return sumAll - sumArr;
    }
}