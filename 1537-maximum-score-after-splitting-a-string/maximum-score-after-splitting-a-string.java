class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] prefixSum=new int[n];
        prefixSum[0]=s.charAt(0) - '0';
        
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + (s.charAt(i) - '0');
        }
        // for(int x:prefixSum)
        // System.out.print(x+" ");

        int zeros=0;
        int maxSum=0,sum=0;

        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0')
            zeros++;

            sum = zeros + (prefixSum[n-1] - prefixSum[i]);
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;

    }
}