class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start=0,end=0;
        int n=nums.length;
        if(n ==  1) return (double)nums[0];
        double sum=0;
        double avg=0;
        double maxAvg=Integer.MIN_VALUE;

        while(end < n){
            while(end - start + 1 <= k){
                sum += nums[end];
                end++;
            }
            avg=sum/k;
            maxAvg=Math.max(maxAvg, avg);
            sum -=nums[start];
            start++;
        }

        return maxAvg;
    }
}