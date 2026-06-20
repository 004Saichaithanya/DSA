class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] hash=new int[101];

        for(int x : nums)
            hash[x]++;

        for(int x : hash)
            {
                if(isPrime(x))
                    return true;
            }

        return false;
    }

    boolean isPrime(int num){
        int cnt = 0;
        if(num < 2) return false;
        for(int i = 1;i<= num;i++){
            if(num % i == 0){
                cnt++;
                if(cnt > 2)
                    return false;
            }
        }
        if(cnt == 2)
            return true;
        
        return false;
    }
}