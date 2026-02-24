class Solution {
    public int findMaxLength(int[] nums) {
         int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
            nums[i]=-1;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        //(sum,firstIndex) ->(0,-1)
        map.put(0,-1);
        int maxLen=0;
        int[] preSum=new int[n];
        preSum[0]=nums[0];
        map.put(preSum[0],0);
        
      //  sum=0;
        
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+nums[i];
            if(!map.containsKey(preSum[i])){
                map.put(preSum[i],i);
            }else{
                int len=i - map.get(preSum[i]);
                maxLen=Math.max(len,maxLen);
            }
            
        }
        return maxLen;
    }
}