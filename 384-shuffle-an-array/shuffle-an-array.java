class Solution {
    int[] org;
    int[] shuff;
    int n;

    public Solution(int[] nums) {
       org = Arrays.copyOf(nums, nums.length); 
        n=nums.length;
   shuff = Arrays.copyOf(org, n); 
    }
    
    public int[] reset() {
    shuff = Arrays.copyOf(org, n); 
        return Arrays.copyOf(org, n);
    }
    
    public int[] shuffle() {
    Random rnd = new Random();
    // int randomNum1 = rnd.nextInt(n);
    //  int randomNum2 = rnd.nextInt(n);
     int temp=0;


    for(int i=n-1;i>=0;i--){
        int j = rnd.nextInt(n);
        temp=shuff[j];
        shuff[j]=shuff[i];
        shuff[i]=temp;
    }
        return Arrays.copyOf(shuff, n);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */