class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int x : nums)
            maxHeap.add(x);

        int i=0;
        int ele = 0;

        while(!maxHeap.isEmpty() && i < k){
            ele = maxHeap.poll();
            i++;
        }


        return ele;
    }
}