class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int total_sum = sum(nums);
        int max_sum = kadane_sum(nums);
        int min_sum = reverse_kadane(nums);

        return (max_sum < 0)?max_sum:Math.max(max_sum , total_sum - min_sum);
    }
    int sum(int[] nums){
        int sum=0;
        for(int x : nums)
            sum += x;

    return sum;
    }
    int kadane_sum(int[] nums){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int x : nums){
            sum += x;
            maxSum = Math.max(maxSum,sum);
            if(sum <0)
                sum=0;
        }

        return maxSum;
    }
    int reverse_kadane(int[] nums){
               int sum=0;
        int minSum=Integer.MAX_VALUE;
        for(int x : nums){
            sum += x;
            minSum = Math.min(minSum,sum);
            if(sum > 0)
                sum=0;
        }

        return minSum;
    }
}