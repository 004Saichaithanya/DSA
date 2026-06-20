class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int x : nums)
            map.put(x,map.getOrDefault(x,0)+1);

        for(int key : map.keySet()){
            if(map.get(key) > Math.floor(n / 2))
                return key;
        }

        return -1;
    }
}