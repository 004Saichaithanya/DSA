class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        if (arr[0] != 1) {
            for (int i = 1; i < n; i++) {
                if (arr[i] == 1) {
                    // Rearrange
                    int temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                }
            }
            //decrease
            if (arr[0] != 1) {
                arr[0] = 1;
            }

        }

        int maxEle = 1;

        for (int i = 1; i < n; i++) {
            if (!(Math.abs(arr[i] - arr[i - 1]) <= 1)) {
                //System.out.println("hello");
                // decrease
                arr[i] = arr[i - 1] + 1;
            }
            maxEle = Math.max(maxEle, arr[i]);
        }

        // for(int x: arr)
        //     System.out.println(x+" ");

        // for (int x : arr)
        //     maxEle = Math.max(maxEle, x);

        return maxEle;
    }
}