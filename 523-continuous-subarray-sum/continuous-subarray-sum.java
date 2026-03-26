class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];

        for(int i=1;i<n;i++)
        pre[i] = pre[i-1] + nums[i];

        // for(int x: pre)
        // System.out.print(x+" ");

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<n;i++){
            int rem = pre[i] % k;
            if(map.containsKey(rem)){
            int prevIndex = map.get(rem);
            if(i - prevIndex >= 2)
            return true;
            }
            else
            map.put(rem,i);
        }



        return false;
    }
}