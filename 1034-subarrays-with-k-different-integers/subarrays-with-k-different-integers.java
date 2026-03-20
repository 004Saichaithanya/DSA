class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtmost(nums,k) - ((k==0)?0:findAtmost(nums,k-1));
    }

    int findAtmost(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        int start=0,end=0;
        int n=nums.length; 

        while(end < n){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);

                while(start < n && map.size() > k){
                    map.put(nums[start],map.get(nums[start])-1);
                    if(map.get(nums[start]) == 0)
                    map.remove(nums[start]);
                    start++;
                }
                cnt+=(end-start+1);
                end++;
        }

       // System.out.println(cnt);

        return cnt;
    }
}