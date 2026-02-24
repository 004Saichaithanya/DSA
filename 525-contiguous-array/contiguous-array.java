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
       // int[] preSum=new int[n];
       int sum=nums[0];
        //preSum[0]=nums[0];
      map.put(sum,0);
        
      //  sum=0;
        
        for(int i=1;i<n;i++){
            sum=sum+nums[i];
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }else{
                int len=i - map.get(sum);
                maxLen=Math.max(len,maxLen);
            }
            
        }
        return maxLen;
    }
}