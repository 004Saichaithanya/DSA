class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        // for(int i=0;i<n;i++)
        // map.put(nums[i],i);

        for(int i=0;i<n;i++){
            int x = nums[i];
            int y = target - x;

            if(map.containsKey(y)){
                ans[0] = i;
                ans[1] = map.get(y);
                break;

            }
            map.put(x,i);
        }



        return ans;
    }
}