class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int minLen=(int)1e9;
     int len=nums.length;
        int sum=0;
        while(j<len){
            while(j<len && sum < target){
                sum += nums[j];
                j++;
            }

            while(i<len && sum >= target){
            minLen=Math.min(minLen,j-i);
            sum-=nums[i];
            i++;
            }
            
        }

        return (minLen == (int)1e9)?0:minLen;
    }
}