class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            preSum[i] = preSum[i - 1] + arr[i];

        // for(int x: preSum)
        // System.out.print(x+" ");

        // System.out.println();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len % 2 == 0)
                    continue;

                if (i == 0)
                    sum += preSum[j];
                else
                    sum += (preSum[j] - preSum[i - 1]);
                //System.out.println(sum+" "+i+" "+j);
            }
        }

        return sum;
    }
}