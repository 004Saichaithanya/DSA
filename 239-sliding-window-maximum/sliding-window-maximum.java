class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start=0,end=0;
        int n=nums.length;
        int maxEle=0;
        ArrayList<Integer> arr=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();

        while(end < n){

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[end]){
                dq.removeLast();
            }

            dq.offerLast(end);

            if(dq.peekFirst() < start)
            dq.removeFirst();

            if((end - start + 1) == k){
                arr.add(nums[dq.peekFirst()]);
                start++;
            }
            end++;
        }

    
        int[] ans=new int[arr.size()];

        for(int i=0;i<ans.length;i++)
        ans[i] = arr.get(i);


        return ans;

    }
}