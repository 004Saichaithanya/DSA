class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();
        
        for(int[] a : grid ){
            for(int ele : a)
            arr.add(ele);
       }
       
       int rem = arr.get(0)%x;
       
       for(int ele : arr){
           if(ele % x != rem) return -1;
       }
       
       Collections.sort(arr);
       
       int target =arr.get(arr.size()/2);
       
       
       
      // boolean ok = true;
       
       
       
      // int minDiff = Integer.MAX_VALUE;
       
 
           int cnt =0;
         //  ok = true;
           for(int ele : arr){
               int diff = Math.abs(ele - target);
               if(diff % x != 0){
                  // ok = false;
                   break;
               }
               cnt += (diff/x);
               
           }
          // if(ok)
            // minDiff = Math.min(minDiff,cnt);
     
       
      
      // System.out.println(arr);
       
       
       
       return cnt;
    }
}